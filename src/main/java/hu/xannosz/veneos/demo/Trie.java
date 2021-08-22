package hu.xannosz.veneos.demo;

import hu.xannosz.veneos.core.VeneosServer;
import hu.xannosz.veneos.core.html.HtmlClass;
import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.box.Div;
import hu.xannosz.veneos.core.html.str.P;
import hu.xannosz.veneos.core.html.str.StringModifiers;
import hu.xannosz.veneos.core.html.structure.Page;
import hu.xannosz.veneos.trie.*;
import hu.xannosz.veneos.util.Scripts;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

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

    private final Map<String, SessionData> sessionDataMap = new HashMap<>();
    private P keyData = new P("");

    public static void main(String[] args) {
        VeneosServer server = new VeneosServer();
        server.createServer(8000);
        Trie trie = new Trie();
        server.setTryHandler(trie);
        server.setHandler(new DefaultTryHttpHandler());
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
                return new ResponseBody(createSnakePage());
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
                return new ResponseBody(createSnakePage());
            }
        }
        if (body.getRequestType().equals(RequestTypes.KEY_STROKE_REQUEST)) { //TODO
            keyData = new P("");
            keyData.add("EventId: " + body.getEventId());
            KeyStrokeEvent keyStrokeEvent = KeyStrokeEvent.getFromMap(body.getAdditionalParams());
            keyData.add(StringModifiers.BR+"Event: " + keyStrokeEvent);
            keyData.addClass(P_CLAZZ);
            return new ResponseBody(new ResponseBody.ComponentStruct(P_CLAZZ, keyData));
        }

        return new ResponseBody();
    }

    private Page createSnakePage() { //TODO
        Page page = new Page();
        page.addComponent(new P("This is snake page"));
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
    }
}
