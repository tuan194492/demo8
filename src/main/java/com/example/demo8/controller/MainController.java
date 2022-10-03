package com.example.demo8.controller;

import com.example.demo8.model.PageType;

import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "mainController")
@SessionScoped
public class MainController implements Serializable {
    @Inject
    private LopController lopController;

    public LopController getLopController() {
        return lopController;
    }

    public void setLopController(LopController lopController) {
        this.lopController = lopController;
    }

    private PageType pageType;

    public MainController() {
        pageType = PageType.Main;
    }

    public PageType getPageType() {
        return pageType;
    }

    public void setPageType(PageType pageType) {
        this.pageType = pageType;
    }

    public boolean isOnPage(PageType pageType) {
        return this.pageType == pageType;
    }

    public void changePage(PageType pageType) {
        this.pageType = pageType;
        lopController.selectLop(null);
    }
}

