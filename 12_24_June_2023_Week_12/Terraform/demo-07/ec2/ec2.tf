
variable "ec2_name"{
  type = string
}

variable "ec2_purpose" {
  type = string
}

resource "aws_instance" "ec2-demo-terraform" {

  // Amazon Linux 2023
  ami = "ami-022e1a32d3f742bd8"
  instance_type = "t2.micro"

  tags = {
    Name = var.ec2_name
    Purpose = var.ec2_purpose  
  }
}

output "ec2_instance_id"{
  value = aws_instance.ec2-demo-terraform.id
}