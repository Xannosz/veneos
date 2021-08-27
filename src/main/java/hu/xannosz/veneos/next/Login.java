package hu.xannosz.veneos.next;

import hu.xannosz.veneos.core.html.HtmlComponent;
import hu.xannosz.veneos.core.html.box.Div;
import hu.xannosz.veneos.core.html.form.Button;
import hu.xannosz.veneos.core.html.form.Form;
import hu.xannosz.veneos.core.html.form.Input;
import hu.xannosz.veneos.core.html.form.Label;
import hu.xannosz.veneos.core.html.str.StringModifiers;
import hu.xannosz.veneos.core.html.structure.Page;

@Deprecated
public class Login extends Page {
    public Login(String target, String buttonName, String userNameLabel, String passwordLabel) {
        this(target, new Button(buttonName), new Label("userName", userNameLabel), new Label("password", passwordLabel));
    }

    public Login(String target, HtmlComponent buttonName, String userNameLabel, String passwordLabel) {
        this(target, new Button(buttonName), new Label("userName", userNameLabel), new Label("password", passwordLabel));
    }

    public Login(String target, String buttonName, HtmlComponent userNameLabel, String passwordLabel) {
        this(target, new Button(buttonName), new Label("userName", userNameLabel), new Label("password", passwordLabel));
    }

    public Login(String target, String buttonName, String userNameLabel, HtmlComponent passwordLabel) {
        this(target, new Button(buttonName), new Label("userName", userNameLabel), new Label("password", passwordLabel));
    }

    public Login(String target, HtmlComponent buttonName, HtmlComponent userNameLabel, HtmlComponent passwordLabel) {
        this(target, new Button(buttonName), new Label("userName", userNameLabel), new Label("password", passwordLabel));
    }

    public Login(String target, String buttonName, HtmlComponent userNameLabel, HtmlComponent passwordLabel) {
        this(target, new Button(buttonName), new Label("userName", userNameLabel), new Label("password", passwordLabel));
    }

    public Login(String target, HtmlComponent buttonName, String userNameLabel, HtmlComponent passwordLabel) {
        this(target, new Button(buttonName), new Label("userName", userNameLabel), new Label("password", passwordLabel));
    }

    public Login(String target, HtmlComponent buttonName, HtmlComponent userNameLabel, String passwordLabel) {
        this(target, new Button(buttonName), new Label("userName", userNameLabel), new Label("password", passwordLabel));
    }

    private Login(String target, Button submit, Label userNameLabel, Label passwordLabel) {
        Div div = new Div();
        Form form = new Form(target, false);

        form.add(userNameLabel);
        Input user = new Input("text");
        user.setName("userName");
        form.add(user);

        form.add(StringModifiers.BR.toString());

        form.add(passwordLabel);
        Input password = new Input("password");
        password.setName("password");
        form.add(password);

        submit.setSubmit();
        form.add(submit);

        div.add(form);
        addComponent(div);
    }
}
