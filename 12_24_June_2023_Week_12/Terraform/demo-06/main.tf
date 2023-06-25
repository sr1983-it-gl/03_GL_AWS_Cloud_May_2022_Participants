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

variable "inbound_ports" {
  type = list(number)
  default = [80, 8080, 443 ]
}

variable "outbound_ports" {
  type = list(number)
  default = [80, 8080, 443 ]
}

resource "aws_security_group" "demo_security_group" {
  
  name = "Demo Security Group - Terraform"

  dynamic "ingress" {

    for_each = var.inbound_ports
    iterator = ref_ingress_port

    content {
      from_port = ref_ingress_port.value
      to_port = ref_ingress_port.value
      protocol = "tcp"
      cidr_blocks = ["0.0.0.0/0"]
    }
  }

  dynamic "egress" {

    for_each = var.outbound_ports
    iterator = ref_egress_port

    content {
      from_port = ref_egress_port.value
      to_port = ref_egress_port.value
      protocol = "tcp"
      cidr_blocks = ["0.0.0.0/0"]
    }
  }
}
