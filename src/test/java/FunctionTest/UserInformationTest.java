package FunctionTest;

import com.pdai.javafx.app.poto.ForumInfo;
import com.pdai.javafx.app.poto.Student;
import org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static com.pdai.javafx.app.utils.JsonUtils.*;
import static org.junit.Assert.assertEquals;

public class UserInformationTest {
    @Test
    public void UserInformationTest() {
        Student student = getStudentInfo();
        assertEquals(student.getName(),"Jason");
        assertEquals(student.getAge(),20);
        assertEquals(student.getMajor(),"E-commerce");
        assertEquals(student.getSchool(),"International School");
        assertEquals(student.getGpa(),4.5,0.1);
        assertEquals(student.getRank(),10);
    }
}
