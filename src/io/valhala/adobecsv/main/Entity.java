package io.valhala.adobecsv.main;

public class Entity {
	
	private boolean isStudent = false;
	
	private String firstName, lastName, username, email, productConfigurations;
	private final String identityType = "Federated ID";
	private final String domain = "trinity.edu";
	private final String countryCode = "US";
	private String adminRoles, productConfigurationsAdministered, userGroups, userGroupsAdministered,
							productsAdministered, developerAccess, autoAssignedProducts = "";
	
	
	public Entity(String firstName, String lastName, String username, String email, String productConfigurations) {
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.productConfigurations = productConfigurations;
		setAdminRoles(",");
		productConfigurationsAdministered = "";
		userGroups = "";
		userGroupsAdministered = "";
		productsAdministered = "";
		developerAccess = "";
		autoAssignedProducts = "";
	}
	
	public Entity(String firstName, String lastName, String username, String email, String productConfigurations,
			String indentityType, String domain, String countryCode, String adminRoles, String productConfigurationsAdministered,
			String userGroups, String userGroupsAdministered, String productsAdministered, String developerAccess,
			String autoAssignedProducts) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.productConfigurations = productConfigurations;
		this.adminRoles = adminRoles;
		this.productConfigurationsAdministered = productConfigurationsAdministered;
		this.userGroups = userGroups;
		this.userGroupsAdministered = userGroupsAdministered;
		this.productsAdministered = productsAdministered;
		this.developerAccess = developerAccess;
		this.autoAssignedProducts = autoAssignedProducts;
	}
	
	public Entity() {}
	
	public void setExtras() {
		
	}


	public boolean isStudent() {
		return isStudent;
	}


	public void setStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getProductConfigurations() {
		return productConfigurations;
	}


	public void setProductConfigurations(String productConfigurations) {
		this.productConfigurations = productConfigurations;
	}


	public String getAdminRoles() {
		return adminRoles;
	}


	public void setAdminRoles(String adminRoles) {
		this.adminRoles = adminRoles;
	}


	public String getProductConfigurationsAdministered() {
		return productConfigurationsAdministered;
	}


	public void setProductConfigurationsAdministered(String productConfigurationsAdministered) {
		this.productConfigurationsAdministered = productConfigurationsAdministered;
	}


	public String getUserGroups() {
		return userGroups;
	}


	public void setUserGroups(String userGroups) {
		this.userGroups = userGroups;
	}


	public String getUserGroupsAdministered() {
		return userGroupsAdministered;
	}


	public void setUserGroupsAdministered(String userGroupsAdministered) {
		this.userGroupsAdministered = userGroupsAdministered;
	}


	public String getProductsAdministered() {
		return productsAdministered;
	}


	public void setProductsAdministered(String productsAdministered) {
		this.productsAdministered = productsAdministered;
	}


	public String getDeveloperAccess() {
		return developerAccess;
	}


	public void setDeveloperAccess(String developerAccess) {
		this.developerAccess = developerAccess;
	}


	public String getAutoAssignedProducts() {
		return autoAssignedProducts;
	}


	public void setAutoAssignedProducts(String autoAssignedProducts) {
		this.autoAssignedProducts = autoAssignedProducts;
	}


	public String getIdentityType() {
		return identityType;
	}


	public String getDomain() {
		return domain;
	}


	public String getCountryCode() {
		return countryCode;
	}

}
