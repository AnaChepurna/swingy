package com.achepurn.view;

import com.achepurn.controller.UserControl;

/**
 * Created by achepurn on 1/30/19.
 */
public interface IView extends Runnable {
    void takeUserControl(UserControl control);
}
