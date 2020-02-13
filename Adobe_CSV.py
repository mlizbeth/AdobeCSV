import sys
import argparse
import csv

#TODO
#@V1.0 
#@Date 2/13/2020
#@Author mlizbeth
#Error handling/utf-8 decoding issues?
#helper function so I don't have a copypasta of the file read/write
#sort/diff switches?

file_headers = ["Identity Type", "Username", "Domain", "Email", "First Name", "Last Name", "Country Code", "Product Configurations", "Admin Roles", "Product Configurations Administered",
                "User Groups", "User Groups Administered", "Products Administered", "Developer Access", "Auto Assigned Products"]      

entitlements = ["Default All Apps plan - 1 TB configuration", "Default Spark with Premium Features for Higher-Ed - 2 GB configuration"]

parser = argparse.ArgumentParser(description="Adobe Entitlement Manager")
parser.add_argument("-i","--input", type=str, help="File to read from", required=True)
parser.add_argument("-o","--output", type=str, help="File to write to", required=True)
parser.add_argument("-m","--mode", type=int, help="Operating Mode.\n\t 1 for FacStaff, 2 for Students", required=True)
args = parser.parse_args()
print(args.input)

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
    product_configurations_administered = ""
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

    def set_product_configurations(self, product_configurations):
        self.product_configurations = product_configurations

    def __str__(self):
        return f"Entity data \nfirst_name: {self.first_name} \nlast_name: {self.last_name} \nusername: {self.username} \nemail: {self.email} \nproduct_configurations: {self.product_configurations}"


def write_document():
    if args.mode is 1:
        with open(args.output, mode='w') as out_file:
            with open(args.input, mode='r') as in_file:
                csv_reader = csv.reader(in_file, delimiter=',')
                csv_writer = csv.writer(out_file, delimiter=',')
                next(in_file) #we want to skip the first line of the in_file since it contains junk data
                csv_writer.writerow(file_headers)
                for row in csv_reader:
                    e = Entity(row[0], row[1], row[2], row[2] + "@trinity.edu", entitlements[0]) #entitlements[1] should be used for students
                    csv_writer.writerow([e.identity_type, e.username, e.domain, e.email, e.first_name, e.last_name, e.country_code, e.product_configurations, e.admin_roles, e.product_configurations_administered, e.user_groups, e.user_groups_administered, e.products_administered, e.developer_access, e.auto_assigned_products])
    elif args.mode is 2:
        with open(args.output, mode='w') as out_file:
            with open(args.input, mode='r') as in_file:
                csv_reader = csv.reader(in_file, delimiter=',')
                csv_writer = csv.writer(out_file, delimiter=',')
                next(in_file) #we want to skip the first line of the in_file since it contains junk data
                csv_writer.writerow(file_headers)
                for row in csv_reader:
                    e = Entity(row[0], row[1], row[2], row[2] + "@trinity.edu", entitlements[1]) #entitlements[1] should be used for students
                    csv_writer.writerow([e.identity_type, e.username, e.domain, e.email, e.first_name, e.last_name, e.country_code, e.product_configurations, e.admin_roles, e.product_configurations_administered, e.user_groups, e.user_groups_administered, e.products_administered, e.developer_access, e.auto_assigned_products])
    else:
        print("Invalid syntax, please refer to documentation")


if __name__ == "__main__":
    if not args.input and not args.output and not args.mode:
        print("You broke something!")
    else:
        write_document()