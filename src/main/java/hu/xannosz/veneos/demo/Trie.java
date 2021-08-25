package hu.xannosz.veneos.demo;

import hu.xannosz.microtools.FileResourcesUtils;
import hu.xannosz.microtools.pack.Douplet;
import hu.xannosz.veneos.core.VeneosServer;
import hu.xannosz.veneos.core.handler.FileContainer;
import hu.xannosz.veneos.core.html.HtmlClass;
import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.box.Div;
import hu.xannosz.veneos.core.html.media.Img;
import hu.xannosz.veneos.core.html.str.P;
import hu.xannosz.veneos.core.html.str.StringModifiers;
import hu.xannosz.veneos.core.html.structure.Page;
import hu.xannosz.veneos.core.html.table.Table;
import hu.xannosz.veneos.trie.*;
import hu.xannosz.veneos.util.Scripts;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Trie implements TryHandler {

    private static final String CHANGE_PAGE = "changePage";
    private static final String CHANGE_DIV = "changeDiv";
    private static final String CHANGE_RESET = "changeReset";
    private static final String CHANGE_SNAKE = "changeToSnake";

    private static final String BASE_PAGE_ID = "basePageId";
    private static final String NEW_PAGE_ID = "newPageId";
    private static final String SNAKE_PAGE_ID = "SnakePageId";

    private static final HtmlClass DIV_CLAZZ = new HtmlClass();
    private static final HtmlClass P_CLAZZ = new HtmlClass();
    public static final int SNAKE_SIZE = 15;

    private final Map<String, SessionData> sessionDataMap = new HashMap<>();
    private P keyData = new P("");

    public static void main(String[] args) {
        VeneosServer server = new VeneosServer();
        server.createServer(8000);
        Trie trie = new Trie();
        server.setTryHandler(trie);
        server.setHandler(new DefaultTryHttpHandler());
    }

    public Trie() {
        FileContainer.addFile("snake_field", FileResourcesUtils.getFileFromResourceAsFile("demo/snake/snake_field.png"));
        FileContainer.addFile("snake_body", FileResourcesUtils.getFileFromResourceAsFile("demo/snake/snake_body.png"));
        FileContainer.addFile("snake_dead_body", FileResourcesUtils.getFileFromResourceAsFile("demo/snake/snake_dead_body.png"));
        FileContainer.addFile("snake_food", FileResourcesUtils.getFileFromResourceAsFile("demo/snake/snake_food.png"));
        FileContainer.addFile("snake_big_food", FileResourcesUtils.getFileFromResourceAsFile("demo/snake/snake_big_food.png"));
    }

    @Override
    public ResponseBody handleRequest(RequestBody body) {
        SessionData data = sessionDataMap.get(body.getSessionId());

        if (data == null) {
            SessionData newData = new SessionData();
            newData.setPageId(BASE_PAGE_ID);
            sessionDataMap.put(body.getSessionId(), newData);
            return new ResponseBody(createMainPage(newData, body));
        }

        if (body.getRequestType().equals(RequestTypes.REFRESH_REQUEST)) {
            if (data.getPageId().equals(BASE_PAGE_ID)) {
                return new ResponseBody(createMainPage(data, body));
            }
            if (data.getPageId().equals(NEW_PAGE_ID)) {
                return new ResponseBody(createNewPage());
            }
            if (data.getPageId().equals(SNAKE_PAGE_ID)) {
                return new ResponseBody(createSnakePage(data.getSnakeData()));
            }
        }
        if (body.getRequestType().equals(RequestTypes.BUTTON_REQUEST)) {
            if (body.getEventId().equals(CHANGE_PAGE)) {
                data.setPageId(NEW_PAGE_ID);
                return new ResponseBody(createNewPage());
            }
            if (body.getEventId().equals(CHANGE_DIV) && data.getPageId().equals(BASE_PAGE_ID)) {
                data.setDivChanged(true);
                return new ResponseBody(new ResponseBody.ComponentStruct(DIV_CLAZZ, createNewDiv(body)));
            }
            if (body.getEventId().equals(CHANGE_RESET)) {
                data.setPageId(BASE_PAGE_ID);
                data.setDivChanged(false);
                return new ResponseBody(createMainPage(data, body));
            }
            if (body.getEventId().equals(CHANGE_SNAKE)) {
                data.setPageId(SNAKE_PAGE_ID);
                return new ResponseBody(createSnakePage(data.getSnakeData()));
            }
        }
        if (body.getRequestType().equals(RequestTypes.KEY_STROKE_REQUEST)) { //TODO
            keyData = new P("");
            keyData.add("EventId: " + body.getEventId());
            KeyStrokeEvent keyStrokeEvent = KeyStrokeEvent.getFromMap(body.getAdditionalParams());
            keyData.add(StringModifiers.BR + "Event: " + keyStrokeEvent);
            keyData.addClass(P_CLAZZ);
            return new ResponseBody(new ResponseBody.ComponentStruct(P_CLAZZ, keyData));
        }

        return new ResponseBody();
    }

    private Page createSnakePage(SnakeData snakeData) { //TODO
        Page page = new Page();
        Table table = new Table();
        for (int y = 0; y < SNAKE_SIZE; y++) {
            for (int x = 0; x < SNAKE_SIZE; x++) {
                table.addCell(new Img("/files/snake_field")
                        .putMeta("width", 30).putMeta("height", 30));
            }
            table.newRow();
        }
        page.addComponent(table);
        page.addComponent(new TryButton(CHANGE_RESET, "Back"));
        return page;
    }

    private static HtmlComponent createNewDiv(RequestBody body) {
        Div div = new Div();
        div.add(new P("RequestType: " + body.getRequestType()));
        div.add(new P("SessionId: " + body.getSessionId()));
        div.add(new P("EventId: " + body.getEventId()));
        div.add(new TryButton(CHANGE_RESET, "Reset"));
        return div;
    }

    private Page createMainPage(SessionData data, RequestBody body) {
        Page page = new Page();
        page.addScript(Scripts.getKeyPressListenerScript(new HashMap<>()));
        page.addScript(Scripts.getAutomaticRefreshScript(5000));

        page.addComponent(new TryButton(CHANGE_PAGE, "Change page"));
        page.addComponent(new TryButton(CHANGE_DIV, "Change div"));
        page.addComponent(new TryButton(CHANGE_SNAKE, "Start snake"));
        page.addComponent(new P("Component: "));

        if (data.isDivChanged()) {
            page.addComponent(createNewDiv(body));
        } else {
            page.addComponent(new Div().addClass(DIV_CLAZZ));
        }

        page.addComponent(keyData.addClass(P_CLAZZ));

        return page;
    }

    private static Page createNewPage() {
        Page page = new Page();
        page.addComponent(new P("This is new page"));
        page.addComponent(new TryButton(CHANGE_RESET, "Back"));
        return page;
    }

    @Data
    public static class SessionData {
        private String pageId;
        private boolean divChanged = false;
        private SnakeData snakeData = new SnakeData();
    }

    public static class SnakeData {
        private Point head;
        private Set<Point> bodies;

        public Douplet<Point,Boolean> getFood(){
            while (true){
                Point food = new Point(new Random().nextInt(SNAKE_SIZE),new Random().nextInt(SNAKE_SIZE));
                if(food.equals(head)){
                    continue;
                }
                if(bodies.contains(food)){
                    continue;
                }
               if(10>new Random().nextInt(100)){
                   return new Douplet<>(food,true);
               }else {
                   return new Douplet<>(food,false);
               }
            }
        }
    }

    @Data
    @AllArgsConstructor
    public static class Point {
        private final int x;
        private final int y;
    }
}
