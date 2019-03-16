package com.achepurn.view;

import com.achepurn.controller.UserControl;

import java.io.IOException;
import java.io.InputStream;

public class UserControlListener implements Runnable {

    private UserControl userControl;
    private InputStream is;
    private IView view;

    public UserControlListener(InputStream is, IView view) {
        this.is = is;
    }

    private void listenUser() throws IOException {
        int i = is.read();
        switch (i) {
            case 'w':
                userControl = UserControl.UP;
                break;
            case 's':
                userControl = UserControl.DOWN;
                break;
            case 'd':
                userControl = UserControl.RIGHT;
                break;
            case 'a':
                userControl = UserControl.LEFT;
                break;
        }
    }

    @Override
    public void run() {
            userControl = null;
            try {
                listenUser();
            } catch (IOException e) {
                e.printStackTrace();
            }
            view.takeUserControl(userControl);
    }
}
