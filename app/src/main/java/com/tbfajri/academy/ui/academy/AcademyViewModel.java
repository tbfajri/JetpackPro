package com.tbfajri.academy.ui.academy;

import com.tbfajri.academy.data.CourseEntity;
import com.tbfajri.academy.utils.DataDummy;

import java.util.List;

import androidx.lifecycle.ViewModel;

public class AcademyViewModel extends ViewModel {

    public List<CourseEntity> getCourses() {
        return DataDummy.generateDummyCourses();
    }
}