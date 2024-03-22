package br.com.SalsaTech.SuiteRunner;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;


import br.com.SalsaTech.Tests.CreateUserTest;
import br.com.SalsaTech.Tests.DeleteUserTest;
import br.com.SalsaTech.Tests.ListAllResourceTest;
import br.com.SalsaTech.Tests.ListPage1DelayedTest;
import br.com.SalsaTech.Tests.ListResourceByIDNotFoundTest;
import br.com.SalsaTech.Tests.ListResourceByIDTest;
import br.com.SalsaTech.Tests.ListUserByIDNotFoundTest;
import br.com.SalsaTech.Tests.ListUserByIDTest;
import br.com.SalsaTech.Tests.ListUsersTest;
import br.com.SalsaTech.Tests.LoginUserNoSuccessTest;
import br.com.SalsaTech.Tests.LoginUserTest;
import br.com.SalsaTech.Tests.PatchUserTest;
import br.com.SalsaTech.Tests.RegisterUserNoSuccessTest;
import br.com.SalsaTech.Tests.RegisterUserTest;
import br.com.SalsaTech.Tests.UpdateUserTest;

    @RunWith(JUnitPlatform.class)
    @SelectClasses({
            CreateUserTest.class,
            DeleteUserTest.class,
            ListAllResourceTest.class,
            ListPage1DelayedTest.class,
            ListResourceByIDNotFoundTest.class,
            ListResourceByIDTest.class,
            ListUserByIDNotFoundTest.class,
            ListUserByIDTest.class,
            ListUsersTest.class,
            LoginUserNoSuccessTest.class,
            LoginUserTest.class,
            PatchUserTest.class,
            RegisterUserNoSuccessTest.class,
            RegisterUserTest.class,
            UpdateUserTest.class
    })
    public class SuiteRunner {
        //Runner Tests
    }
