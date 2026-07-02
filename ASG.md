#Auto Scaling Group (ASG)

1.Go to Auto Scaling Groups in the EC2 dashboard and click on "Create Auto Scaling Group".
2.Choose a launch template or configuration for your instances. If you don't have one, you can create a new launch template that 
specifies the AMI, instance type, key pair, security group, and other settings for your instances.
3.Configure the Auto Scaling Group settings, including the group name, VPC, subnets, and desired capacity (the number of instances you want to run).
4.Set up scaling policies to automatically adjust the number of instances in your Auto Scaling Group based on metrics such as CPU utilization or request count. You can create target tracking policies, step scaling policies,
    or simple scaling policies depending on your needs.
5.Configure health checks to monitor the health of your instances. You can choose between EC2 status checks or ELB health checks if you're using a load balancer.
6.Review your settings and click "Create Auto Scaling Group" to launch your instances and start automatically scaling based on your defined policies.
7.Monitor your Auto Scaling Group using the EC2 dashboard, CloudWatch metrics, and alarms to ensure that your instances are scaling as expected and that your application remains available and responsive.         

