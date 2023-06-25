

terraform {
  required_providers {
    artifactory = {
      source = "jfrog/artifactory"
      version = "8.2.2"
    }
  }
}

provider "aws" {

  region = "us-east-1"  

}

provider "artifactory" {
  # Configuration options
}

resource "aws_vpc" "my_vpc" {
  
  cidr_block = "10.0.0.0/16"
}