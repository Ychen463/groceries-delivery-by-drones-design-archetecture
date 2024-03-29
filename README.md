# Drone-Based Grocery Delivery System

## Overview

This project aims to revolutionize the grocery delivery landscape by implementing a drone-based delivery system. With a focus on scalability and security, the system leverages serverless architecture and robust authentication mechanisms.

### Class Diagram
<img src="./System Design/class_diagram.png" alt="class_diagram" title="class_diagram">

### Sequence Diagram
<img src="./System Design/sequence_diagram1.png" alt="sequence_diagram1" title="sequence_diagram1">
<img src="./System Design/sequence_diagram2.png" alt="sequence_diagram2" title="sequence_diagram2">



### Scalable Drone-Order Assignment
- **Dynamic Order Assignment**: Drones are assigned to orders only when they are ready for delivery.
- **Location-based Loading**: Orders are grouped by zip codes to optimize drone routes.

### Serverless Architecture
- **AWS Lambdas**: Individual lambda functions for each system operation.
- **API Gateway**: A single gateway to route system operations and trigger lambdas.

### Robust Security
- **Multi-Factor Authentication (MFA)**: Enhanced security at the user level.
- **Role-based Access**: Different access levels for customers and employees.

## Getting Started

### Prerequisites
- AWS Account
- Node.js
- Serverless Framework

### Installation
1. Clone the repository
   ```bash
   git clone https://github.com/Ychen463/groceries-delivery-by-drones-design-archetecture.git# To Install Docker go to:
   ```
2. Docker
   ```bash
   https://docs.docker.com/get-docker/
   ```

# Note please run all scripts from the project root directory

### To build:

```
docker build -t gatech/dronedelivery -f Dockerfile ./
```

### To test a specific scenario against the initial jar
#### Mac / Linux
```
./scripts/test.sh <scenario>
```
#### Windows
```
.\scripts\test.sh <scenario>
```

### To batch run the test scenarios
#### Mac / Linux
```
./scripts/batch.sh
```
#### Windows
```
.\scripts\batch.sh
```

### To run in interactive mode
#### Step 1 from the host
```
docker run -ti gatech/dronedelivery sh
```
#### Step 2 from the container
```
java -jar drone_delivery.jar
```
#### Step 3 from the jar
* From there you can run any of the commands listed from the assignment:
```
make_store,<Store>,<InitialRevenue>
display_stores
sell_item,<Store>,<Item>,<Weight>
display_items,<Store>
make_pilot,<Account>,<FirstName>,<LastName>,<PhoneNumber>,<TaxId>,<LicenseId>,<ExperienceLevel>
display_pilots
make_drone,<Store>,<DroneId>,<WeightCapacity>,<NumberOfDeliveries>
display_drones,<Store>
fly_drone,<Store>,<DroneId>,<PilotAccount>
make_customer,<Account>,<FirstName>,<LastName>,<PhoneNumber>,<CustomerRating>,<Credits>
display_customers
start_order,<Store>,<OrderId>,<DroneId>,<CustomerAccount>
display_orders,<Store>
request_item,<Store>,<OrderId>,<Item>,<Quantity>,<UnitPrice>
purchase_order,<Store>,<OrderId>
cancel_order,<Store>,<OrderId>
stop
```

### To run & test in interactive mode

```
java -jar drone_delivery.jar < commands_00.txt > drone_delivery_00_results.txt
diff -s drone_delivery_00_results.txt drone_delivery_initial_00_results.txt > results_00.txt
cat results_00.txt
```

### To run a specific scenario with your jar and output to localhost
The "mkdir docker_results ; " would not be needed after the 1st run, but just in case you have not made the directory yet with another command. 
```
mkdir docker_results ; docker run gatech/dronedelivery sh -c 'java -jar drone_delivery.jar < commands_00.txt'  > docker_results/drone_delivery_00_results.txt
```

### If you get stuck in an infinite loop
Simply stop and remove the running container
```
docker ps
docker rm -f <container_id>
```

### To test with a clean image & container
After running the below command you will need to run the build command again
```
docker ps -aq | % { docker stop $_ } | % { docker rm -f $_ } | docker images -f "dangling=true" -aq | % { docker rmi -f $_ } | docker images gatech/* -aq | % { docker rmi -f $_ }
```

### Assignment Q&A Post
Please post any questions about docker or otherwise to the post linked below:  
[Link To Ed Discussion](https://edstem.org/us/courses/16683/discussion/1141860)
