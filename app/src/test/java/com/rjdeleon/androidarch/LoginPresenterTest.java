package com.rjdeleon.androidarch;

import com.rjdeleon.androidarch.Login.LoginActivityPresenter;
import com.rjdeleon.androidarch.Login.LoginActivityMVP;
import com.rjdeleon.androidarch.Login.User;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class LoginPresenterTest {

    LoginActivityMVP.Model mockModel;
    LoginActivityMVP.View mockView;
    LoginActivityPresenter presenter;
    User user;

    @Before
    public void setup() {

        mockModel = mock(LoginActivityMVP.Model.class);

        user = new User("Fox", "Mulder");

        mockView = mock(LoginActivityMVP.View.class);

        presenter = new LoginActivityPresenter(mockModel);
        presenter.setView(mockView);
    }

    @Test
    public void loadTheUserFromTheRepositoryWhenValidUserIsPresent() {
        when(mockModel.getUser()).thenReturn(user);

        presenter.getCurrentUser();

        // Verify model interactions
        verify(mockModel, times(1)).getUser();

        // Verify view interactions
        verify(mockView, times(1)).setFirstName("Fox");
        verify(mockView, times(1)).setLastName("Mulder");
        verify(mockView, never()).showUserNotAvailable();
    }

    @Test
    public void shouldShowErrorMessageWhenUserIsNull() {
        when(mockModel.getUser()).thenReturn(null);

        presenter.getCurrentUser();

        // Verify model interactions
        verify(mockModel, times(1)).getUser();

        // Verify view interactions
        verify(mockView, never()).setFirstName("Fox");
        verify(mockView, never()).setLastName("Mulder");
        verify(mockView, times(1)).showUserNotAvailable();

    }
}
