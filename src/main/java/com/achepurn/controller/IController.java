package com.achepurn.controller;

import com.achepurn.model.Hero;
import com.achepurn.model.Model;
import com.achepurn.view.IView;

import java.io.IOException;

/**
 * Created by achepurn on 1/30/19.
 */
public interface IController {
    Hero getHero();
    String getUserString() throws IOException;
}
