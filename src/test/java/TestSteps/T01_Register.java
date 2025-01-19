package TestSteps;

import Pages.Home_Page;
import Pages.P01_Register_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T01_Register extends Testbase{

    Home_Page R1=new Home_Page();
    P01_Register_Page R2=new P01_Register_Page();
    String url_of_creat_acount_page="https://magento.softwaretestingboard.com/customer/account/create/";
    String actual_url_creatacount_page;
    String name="Bishoy";
    String lastname="Adel";
    String email="bishoyadel2018188356@gmail.com";
    String PASSWORD="B1234566#";
    String confirmedpassword="B1234566#";
    String WRONG_confirmedpassword="bhjhjjh";
    String required_filed_message="This is a required field.";
    String req_field_excpected_message;
    String Please_enter_the_same_value_again_message="Please enter the same value again.";
    String Please_enter_the_same_value_again_actual_message;
    String FISRT_NAME_ACCOUNTINFORMATION;
    String LAST_NAME_ACCOUNTINFORMATION;
    String EMAIL_ACCOUNTINFORMATION;
    Boolean Firstname_check;
    Boolean Lastname_check;
    Boolean email_check;


    // String EMAIL_ACCOUNTINFORMATION;
    /********************************************************************************************

   THIS SCENARIO THE USER CREATE ACCOUNT AND CLICK SUBMIT WITHOUT ENTERED THE CONFIRMED PASSWORD
     CHECK THAT THE MESSAGE APPEAR "This is a required field."

    ***********************************************************************************************/
    @Test(priority = 1)
    public void Register_page_scenario1()
    {
        R1.Click_on_creat_acount_button();
        actual_url_creatacount_page= R2.GET_URL_OF_CREATACOUNT_PAGE();
        Assert.assertEquals(actual_url_creatacount_page,url_of_creat_acount_page);
        R2.Enter_First_name(name);
        R2.Enter_Last_name(lastname);
        R2.Enter_EMAIL(email);
        R2.Enter_Password(PASSWORD);
        R2.Click_Creat_ACCOUNT();
        req_field_excpected_message=R2.GET_This_is_required_field();
        Assert.assertEquals(required_filed_message,req_field_excpected_message);
    }


    /********************************************************************************************

     THIS SCENARIO THE USER CREATE ACCOUNT ,ENTERED THE WRONG CONFIRMATION PASSWORD AND CLICK SUBMIT&
     CHECK THAT THE MESSAGE APPEAR "Please enter the same value again."
     ***********************************************************************************************/

    @Test(priority = 2)
    public void Register_page_Register_page_scenario2()
    {
        R1.Click_on_creat_acount_button();
        R2.Enter_First_name(name);
        R2.Enter_Last_name(lastname);
        R2.Enter_EMAIL(email);
        R2.Enter_Password(PASSWORD);
        R2.Enter_Confirmed_Password(WRONG_confirmedpassword);
        R2.Click_Creat_ACCOUNT();
        Please_enter_the_same_value_again_actual_message=R2.GET_Please_enter_the_same_value_again();
        Assert.assertEquals(Please_enter_the_same_value_again_message,Please_enter_the_same_value_again_actual_message);

    }


    /********************************************************************************************
     THIS SCENARIO THE USER CREATE ACCOUNT ,ADD ALL VALID DATA THEN CLICK SUBMIT&EN
        CHECK THAT THE FIRST NAME IN CONTACT INFORMATION IS AS THE USER ENTERED
        CHECK THAT THE LAST NAME IN CONTACT INFORMATION IS AS THE USER ENTERED
        CHECK THAT THE EMAIL IN CONTACT INFORMATION IS AS THE USER ENTERED
     ***********************************************************************************************/


    @Test(priority = 3)
    public void Register_page_Register_page_scenario3()
    {
        R1.Click_on_creat_acount_button();
        R2.Enter_First_name(name);
        R2.Enter_Last_name(lastname);
        R2.Enter_EMAIL(email);
        R2.Enter_Password(PASSWORD);
        R2.Enter_Confirmed_Password(confirmedpassword);
        R2.Click_Creat_ACCOUNT();

        FISRT_NAME_ACCOUNTINFORMATION=R2.Get_contact_information_firstname();
        Firstname_check=FISRT_NAME_ACCOUNTINFORMATION.contains(name);
        Assert.assertTrue(Firstname_check);

        LAST_NAME_ACCOUNTINFORMATION=R2.Get_contact_information_lastname();
        Lastname_check=LAST_NAME_ACCOUNTINFORMATION.contains(lastname);
        Assert.assertTrue(Lastname_check);

        EMAIL_ACCOUNTINFORMATION= R2.Get_contact_information_email();
        email_check=EMAIL_ACCOUNTINFORMATION.contains(email);
        System.out.println(EMAIL_ACCOUNTINFORMATION);
        System.out.println(LAST_NAME_ACCOUNTINFORMATION);
        Assert.assertTrue(email_check);


    }

}
