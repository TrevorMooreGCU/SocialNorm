package com.socialnorm;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import com.socialnorm.controller.CreateController;
import com.socialnorm.controller.DeleteController;
import com.socialnorm.controller.HomeController;
import com.socialnorm.controller.LoginController;
import com.socialnorm.controller.RegisterController;
import com.socialnorm.controller.SearchController;
import com.socialnorm.controller.UpdateController;
import com.socialnorm.controller.ViewTopicController;
import com.socialnorm.model.ChatModel;
import com.socialnorm.model.CommentModel;
import com.socialnorm.model.CredentialModel;
import com.socialnorm.model.MessageModel;
import com.socialnorm.model.RegisterModel;
import com.socialnorm.model.TopicModel;
import com.socialnorm.services.business.ILoginService;
import com.socialnorm.services.business.IRegisterService;
import com.socialnorm.services.business.ITopicService;
import com.socialnorm.services.business.LoginService;
import com.socialnorm.services.business.RegisterService;
import com.socialnorm.services.business.TopicService;
import com.socialnorm.services.data.DataAccessInterface;
import com.socialnorm.services.data.RegistrationDAO;
import com.socialnorm.services.data.SecurityDAO;
import com.socialnorm.services.data.TopicDAO;

/**
 * Trevor Moore
 * CST-341
 * 10/10/2018
 * This assignment was completed in collaboration with Aaron Ross
 * This is our own work.
 * 
 * ApplicationConfiguration class for defining all our SpringBeans
 * @author Trevor
 *
 */
@Configuration
public class ApplicationConfiguration 
{
	/// CONTROLLERS ///
	/**
	 * Getter for the HomeController SpringBean
	 * @return type HomeController
	 */
	@Bean(name="homeController")
	public HomeController getHomeController()
	{
		return new HomeController();
	}
	/**
	 * Getter for the LoginController SpringBean
	 * @return type LoginController
	 */
	@Bean(name="loginController")
	public LoginController getLoginController()
	{
		return new LoginController();
	}
	/**
	 * Getter for the RegisterController SpringBean
	 * @return type RegisterController
	 */
	@Bean(name="registerController")
	public RegisterController getRegisterController()
	{
		return new RegisterController();
	}
	/**
	 * Getter for the SearchController SpringBean
	 * @return type SearchController
	 */
	@Bean(name="searchController")
	public SearchController getSearchController()
	{
		return new SearchController();
	}
	/**
	 * Getter for the CreateController SpringBean
	 * @return type CreateController
	 */
	@Bean(name="createController")
	public CreateController getCreateController()
	{
		return new CreateController();
	}
	/**
	 * Getter for the ViewTopicController SpringBean
	 * @return type CreateController
	 */
	@Bean(name="viewTopicController")
	public ViewTopicController getViewTopicController()
	{
		return new ViewTopicController();
	}
	/**
	 * Getter for the UpdateController SpringBean
	 * @return type UpdateController
	 */
	@Bean(name="updateController")
	public UpdateController getUpdateController()
	{
		return new UpdateController();
	}
	/**
	 * Getter for the DeleteController SpringBean
	 * @return type DeleteController
	 */
	@Bean(name="deleteController")
	public DeleteController getDeleteController()
	{
		return new DeleteController();
	}
	
	
	/// BUSINESS SERVICES ///
	/**
	 * Getter for LoginService SpringBean (request scoped)
	 * @return type ILoginService
	 */
	@Bean(name="loginService")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public ILoginService getLoginService()
	{
		return new LoginService();
	}
	/**
	 * Getter for RegisterService SpringBean (request scoped)
	 * @return type IRegisterService
	 */
	@Bean(name="registerService")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IRegisterService getRegisterService()
	{
		return new RegisterService();
	}
	/**
	 * Getter for TopicPostService SpringBean (request scoped)
	 * @return type ITopicPostService
	 */
	@Bean(name="topicService")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public ITopicService getTopicService()
	{
		return new TopicService();
	}
	
	
	/// DATA SERVICES ///
	/**
	 * Getter for SecurityDAO SpringBean (request scoped)
	 * @return type ISecurityDAO
	 */
	@Bean(name="securityDAO")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	@Qualifier("security")
	public DataAccessInterface<RegisterModel,CredentialModel,TopicModel,CommentModel,ChatModel,MessageModel> getSecurityDAO()
	{
		return new SecurityDAO();
	}
	/**
	 * Getter for RegistrationDAO SpringBean (request scoped)
	 * @return type IRegistrationDAO
	 */
	@Bean(name="registrationDAO")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	@Qualifier("register")
	public DataAccessInterface<RegisterModel,CredentialModel,TopicModel,CommentModel,ChatModel,MessageModel> getRegistrationDAO()
	{
		return new RegistrationDAO();
	}
	/**
	 * Getter for TopicDAO SpringBean (request scoped)
	 * @return type ITopicDAO
	 */
	@Bean(name="topicDAO")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	@Qualifier("topic")
	public DataAccessInterface<RegisterModel,CredentialModel,TopicModel,CommentModel,ChatModel,MessageModel> getTopicDAO()
	{
		return new TopicDAO();
	}
	
	
	/// DATA SOURCE ///
	/**
	 * Getter for DataSource SpringBean (singleton scoped)
	 * @return type DataSource
	 */
	@Bean(name="dataSource", destroyMethod = "close")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public DataSource getDataSource()
	{
		// Local/Derby:
		// org.apache.derby.jdbc.EmbeddedDriver
		// jdbc:derby:C:\\Users\\Trevor\\SocialNormDB
		// user
		// derby
		
		// Heroku/MySQL:
		// com.mysql.jdbc.Driver
		// jdbc:mysql://aucxibl2dxeo01wa:hytrxvvxgrfx6e02@l9dwvv6j64hlhpul.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/n1euzrfjibaye0bl
		// aucxibl2dxeo01wa
		// hytrxvvxgrfx6e02
		DataSource dataSource = new DataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://aucxibl2dxeo01wa:hytrxvvxgrfx6e02@l9dwvv6j64hlhpul.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/n1euzrfjibaye0bl");
	    dataSource.setUsername("aucxibl2dxeo01wa");
	    dataSource.setPassword("hytrxvvxgrfx6e02"); 
	    dataSource.setInitialSize(2);
	    return dataSource;
	}
	
}
