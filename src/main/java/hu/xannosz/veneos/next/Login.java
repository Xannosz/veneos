package hu.xannosz.veneos.next;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.StringHtmlComponent;
import hu.xannosz.veneos.core.html.box.Div;
import hu.xannosz.veneos.core.html.form.Button;
import hu.xannosz.veneos.core.html.form.Form;
import hu.xannosz.veneos.core.html.form.Input;
import hu.xannosz.veneos.core.html.form.Label;
import hu.xannosz.veneos.core.html.str.StringModifiers;
import hu.xannosz.veneos.core.html.structure.Page;

public class Login extends Page {
    public Login(String target, String buttonName, String userNameLabel, String passwordLabel) {
        this(target, new StringHtmlComponent(buttonName), new StringHtmlComponent(userNameLabel), new StringHtmlComponent(passwordLabel));
    }

    public Login(String target, HtmlComponent buttonName, HtmlComponent userNameLabel, HtmlComponent passwordLabel) {
        Div div = new Div();
        Form form = new Form(target, false);

        Label userLabel = new Label("userName", userNameLabel);
        form.add(userLabel);
        Input user = new Input("text");
        user.setName("userName");
        form.add(user);

        form.add(new StringHtmlComponent(StringModifiers.BR.toString()));

        Label passwdLabel = new Label("password", passwordLabel);
        form.add(passwdLabel);
        Input password = new Input("password");
        password.setName("password");
        form.add(password);

        Button submit = new Button(buttonName);
        submit.setSubmit();
        form.add(submit);

        div.add(form);
        addComponent(div);
    }
}
