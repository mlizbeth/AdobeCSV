import enum

class Entity:
    first_name = ""
    last_name = ""
    username = ""
    email = ""
    product_configurations = ""
    identity_type = "Federated ID"
    domain = "trinity.edu"
    country_code = "US"
    # @Optional Params
    admin_roles = ""
    user_groups = ""
    user_groups_administered = ""
    products_administered = ""
    developer_access = ""
    auto_assigned_products = ""

    def __init__(self, first_name, last_name, username, email, product_configurations, admin_roles=None, product_configurations_administered=None, user_groups=None, user_groups_administered=None, products_administered=None, developer_access=None, auto_assigned_products=None):
        self.first_name = first_name
        self.last_name = last_name
        self.username = username
        self.email = email
        self.product_configurations = product_configurations

    def __str__(self):
        return f"Entity data \nfirst_name: {self.first_name} \nlast_name: {self.last_name} \nusername: {self.username} \nemail: {self.email} \nproduct_configurations: {self.product_configurations}"


class Mode(enum.Enum):
    FACSTAFF = 1
    STUDENT = 2

file_headers = ["Identity Type", "Username", "Domain", "Email", "First Name", "Last Name", "Country Code", "Product Configurations", "Admin Roles", "Product Configurations Administered",
                "User Groups", "User Groups Administered", "Products Administered", "Developer Access", "Auto Assigned Products"]      


#TODO
# Get operation mode
# Read in_file
# Write to out_file based on mode  
