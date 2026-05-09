# EC2 Setup Steps

<span style="color: red;">1. **Create ec2 instance**</span>

<span style="color: red;">2. **Create Key-value pair**</span>
   - Key pair is a set of security credentials that you use to prove your identity when connecting to an EC2 instance.
   - It consists of a public key that AWS stores and a private key that you download and keep secure.
   - You use the private key to SSH into your EC2 instance.

<span style="color: red;">3. **Create security group**</span>
   - Security Group like a firewall that controls traffic to and from your EC2 instance.
   - It has rules that allow or deny specific types of traffic based on protocols, ports, and source/destination IP addresses.

<span style="color: red;">4. **Add rule in security group**</span>

<span style="color: red;">5. **Add this to user data**</span>
#!/bin/bash
yum update -y
yum install -y httpd
systemctl enable httpd
systemctl start httpd
echo "<h4>Hello world from $(hostname -f)</h4>" > /var/www/html/index.html
just a simple script to install httpd and start it and create a simple html file to test that httpd is working or not. 
When you launch an EC2 instance, you can provide user data in the form of a script that will run automatically when the instance starts. 
This is useful for automating the setup and configuration of your instance.

<span style="color: red;">6. **Launch instance**</span>

<span style="color: red;">7. **Go to details**</span>
   - You will see instance id, public IP address, and private IP address, key pair

<span style="color: red;">8. **Go to Security**</span>
   - You can see security group and IAM Role Inbound and outbound rules
   - Add IAM role to ec2 instance

In EC2 Inbound and Outbound rules are part of the security group configuration that controls the traffic to and from your EC2 instance.:

Inbound Rules = Control incoming traffic to your EC2 instance
Outbound Rules = Control outgoing traffic from your EC2 instance
Example

If you run a web server (httpd) on EC2:

Inbound Rule........

Allow users to access your website.

Type	Port	Source	Purpose
HTTP	80	0.0.0.0/0	Allow website traffic If you delete that it will not be accessible from the internet.
SSH	22	Your IP	Allow SSH login If you delete that you will not be able to connect to your instance using SSH. You can also restrict it to your IP for better security.

Meaning:
Port 80 allows browsers to open your website
Port 22 allows SSH connection
Outbound Rule

Allow EC2 to access the internet.

Type	Port	Destination	Purpose
All Traffic	All	0.0.0.0/0	Allow internet access

Meaning:

EC2 can download packages using:

yum update -y
EC2 can access APIs, websites, updates, etc.
Simple Analogy
Inbound → Visitors entering your house
Outbound → You going outside your house

Public Ipv4 vs Private Ipv4..............................
In an Amazon Web Services EC2 instance, the difference is mainly where the IP can be reached from.

Type	Example	Reachable From	Purpose
Private IPv4	172.31.25.101	Inside the VPC only	Internal communication
Public IPv4	13.233.120.55	Internet	External access
Private IPv4
Assigned inside your VPC network
Used for communication between EC2 instances, RDS, load balancers, etc.
Cannot be accessed directly from the internet
More secure for backend services

Example:

172.31.25.101

You use it for:

App server ↔ Database
Internal APIs
SSH from bastion host


Public IPv4
Internet-accessible IP
AWS maps this to the private IP using NAT
Needed for:
Opening website in browser
SSH from your laptop
Public APIs

Public IPs can be dynamic (assigned at launch) or Elastic (static, can be moved between instances).
Private IPs remain the same as long as the instance is running, even if you stop/start it.

<span style="color: red;">9. **Connect to EC2 instance using SSH**</span>
   - You can give command like `aws --version` to check aws cli is working or not
   - `ping google.com` to check internet connectivity
   - Want to stop current execution press `ctrl+c`
   - If you give `aws iam list-users` you will get error because we have not given permission to ec2 instance to access iam service
   - You can use command `aws configure` it will ask for access key and secret key you can give that but it is not recommended because it will store those credentials in `.aws/credentials` file and if someone get access to that file they can use those credentials to access your AWS account.
   - So it is better to give permission to ec2 instance using IAM role.
   - Go to EC2 instance action → modify iam role → attach existing role and select the role which you have created for ec2 instance with required permissions.
   - After that you can run command like `aws iam list-users` and it will work because now ec2 instance has permission to access iam service.
