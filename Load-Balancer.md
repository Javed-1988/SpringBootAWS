# Load Balancer

<span style="color: red;">1. **AWS Elastic Load Balancer(ELB)**</span>

1.ALB → Application Load Balancer...........(It distributed the traffic to multiple targets (EC2 instances, IP addresses, Lambda functions) based on the content of the request. It is designed to handle HTTP and HTTPS traffic and provides advanced routing features.)
i.Use it for HTTP/HTTPS traffic
ii.Operates at Layer 7 (Application Layer)
iii.For ALB you have to create instance like 1 or 2 or 3 or more based on the load it will send request to that instance and if one instance is not working then it will send request to another instance which is healthy. It is used for web applications, REST APIs, and microservices.
iv.Create 2 EC2 Instances
v.Run the instance check it is working or not by using public IP address of the instance
vi.Create ALB go to ALB create new security group or select existing create target group and add both EC2 instances to target group and then create ALB and select the target group and then test it by using ALB DNS name in the browser you will see the same output as you see when you access EC2 instance by using public IP address of the instance.
vii.Target group is a logical grouping of targets (EC2 instances, IP addresses, Lambda functions) that a load balancer routes traffic to. It defines the protocol and port for routing traffic to the targets and also includes health check settings to monitor the health of the targets.
User Request
↓
ALB Listener
↓
Target Group
↓
Targets (EC2 / ECS / IP / Lambda)
viii.Go to Target group and target you will see the health status of your instance like EC2,ECS, IP, Lambda if it is healthy or not. If it is unhealthy then it will not route the traffic to that instance and it will route the traffic to healthy instance only.
ix.Stop one EC2 instance and check the health status of that instance in target group it will show unhealthy and then check the ALB DNS name in the browser you will see the same output as you see when you access EC2 instance by using public IP address of the instance because it is routing the traffic to healthy instance only. If you start that instance again then it will show healthy in target group and then check the ALB DNS name in the browser you will see the same output as you see when you access EC2 instance by using public IP address of the instance because it is routing the traffic to healthy instance only.
x.When you delete EC2 Instance delete also ALB and Target Group otherwise it will cost money because ALB and Target Group are not free. You will be charged for the ALB and Target Group even if you delete the EC2 instance. So, always delete the ALB and Target Group when you delete the EC2 instance to avoid unnecessary costs.

2.NLB → Network Load Balancer........
           Use Case	               Recommended
Web apps / REST APIs / Spring Boot	  ALB
TCP/UDP high-performance traffic	  NLB

i.Use it for TCP/UDP traffic
ii.Operates at Layer 4 (Transport Layer)
iii.Supports high performance and low latency

3.GWLB → Gateway Load Balancer (advanced networking)..........

