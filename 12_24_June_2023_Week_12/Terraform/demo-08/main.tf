terraform {
  required_providers {
    aws = {
      source = "hashicorp/aws"
      version = "5.5.0"
    }
  }

  backend "s3" {
    
    bucket = "terraform-bucket-demo-24-june-2-23"
    key = "demo-app/demo.tfstate"
    region = "us-east-1"
  }

}

provider "aws" {

  region = "us-east-1"  

}

resource "aws_vpc" "my_vpc" {
  
  cidr_block = "10.0.0.0/16"
}