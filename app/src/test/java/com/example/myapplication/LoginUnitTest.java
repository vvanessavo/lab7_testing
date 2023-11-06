package com.example.myapplication;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginUnitTest {

    private static final String FAKE_STRING_SUCCESS = "Login was successful";
    private static final String FAKE_STRING_FAILED = "Invalid login!";

    @Mock
    Context mMockContext;

    @Test
    public void readStringFromContext_LocalizedString() {

        LoginActivity myObjectUnderTest = new LoginActivity(mMockContext);

        // Test with a valid email address
        String result0 = myObjectUnderTest.validate("test@test.com","admin");
        assertThat(result0, is(FAKE_STRING_SUCCESS));

        // Test with an invalid email address
        String result1 = myObjectUnderTest.validate("te4st@eee","admin");
        assertThat(result1, is(FAKE_STRING_FAILED));
    }
}