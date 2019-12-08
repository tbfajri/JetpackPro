package com.tbfajri.academy.ui.bookmark;

import com.tbfajri.academy.data.CourseEntity;
import com.tbfajri.academy.utils.DataDummy;

import java.util.List;

import androidx.lifecycle.ViewModel;

public class BookmarkViewModel extends ViewModel {

    List<CourseEntity> getBookmarks() {
        return DataDummy.generateDummyCourses();
    }
}
