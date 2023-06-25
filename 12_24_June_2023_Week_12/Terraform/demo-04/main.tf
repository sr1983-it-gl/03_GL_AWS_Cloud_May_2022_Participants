
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

variable "cidr_block"{
  type = string
  # default = "10.0.0.0/16"
}

resource "aws_vpc" "my_vpc" {
  
  cidr_block = var.cidr_block
}