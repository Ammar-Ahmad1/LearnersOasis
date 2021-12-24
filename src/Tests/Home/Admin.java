package Tests.Home;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import Home.Controller.AdminController;
import Home.Model.AuthTypes;

class Admin {

	@Test
	void login_success() {
		AdminController ac = new AdminController();
		AuthTypes a = ac.login("afrasyab", "1234");
		Assert.assertEquals(a, AuthTypes.LoginSucces);
	}
	@Test
	void login_invalid_password() {
		AdminController ac = new AdminController();
		AuthTypes a = ac.login("afrasyab", "12345");
		Assert.assertEquals(a, AuthTypes.PasswordFailed);
	}
	@Test
	void login_invalid_username() {
		AdminController ac = new AdminController();
		AuthTypes a = ac.login("afrasya", "1234");
		Assert.assertEquals(a, AuthTypes.UserNameFailed);
	}
}
