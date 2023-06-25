

terraform {
  required_providers {
    aws = {
      source = "hashicorp/aws"
      version = "5.5.0"
    }
  }
}


provider "aws" {

  region = "us-east-1"  

}

resource "aws_security_group" "demo_security_group" {
  
  name = "Demo Security Group - Terraform"

  ingress {

    from_port = "80"
    to_port = "100"
    protocol = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {

    from_port = "80"
    to_port = "100"
    protocol = "tcp"
    cidr_blocks = ["0.0.0.0/0"]

  }
}

resource "aws_instance" "ec2-demo-terraform" {

  // Amazon Linux 2023
  ami = "ami-022e1a32d3f742bd8"
  instance_type = "t2.micro"

  security_groups = [aws_security_group.demo_security_group.name]

  tags = {
    Name = "Demo EC2 from Terraform"
    EC2Type = "WebServer"  
  }
}

resource "aws_eip" "eip_for_ec2" {

  instance = aws_instance.ec2-demo-terraform.id
}

output "ec2-public-ip" {
  value = aws_instance.ec2-demo-terraform.public_ip
}

output "ec2-private-ip" {
  value = aws_instance.ec2-demo-terraform.private_ip
}
