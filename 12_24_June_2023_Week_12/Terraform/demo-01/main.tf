
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

resource "aws_vpc" "my_vpc" {
  
  cidr_block = "10.0.0.0/16"
}