package com.example.agamagiera.notekeeper;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataManagerTest {
    static DataManager sDataManager;

    @Before
    public void classSetUp() throws Exception {
        sDataManager = DataManager.getInstance();
    }

    @Test
    public void createNewNote() throws Exception {
        final DataManager dm = DataManager.getInstance();
        final CourseInfo course = dm.getCourse("android_async");
        final String noteTitle = "Test note title";
        final String noteText = "This is the body text of my test note";

        int noteIndex = dm.createNewNote();
        NoteInfo newNote = dm.getNotes().get(noteIndex);
        newNote.setCourse(course);
        newNote.setTitle(noteTitle);
        newNote.setText(noteText);

        NoteInfo compareNote = dm.getNotes().get(noteIndex);
        assertEquals(compareNote.getCourse(), course);
        assertEquals(compareNote.getTitle(), noteTitle);
        assertEquals(compareNote.getText(), noteText);
    }
}
