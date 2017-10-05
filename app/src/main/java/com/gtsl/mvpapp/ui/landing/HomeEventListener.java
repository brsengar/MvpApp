package com.gtsl.mvpapp.ui.landing;

import com.gtsl.mvpapp.data.model.Title;

import java.util.List;

public interface HomeEventListener {
    void onPopulate(List<Title> titleList);
}
