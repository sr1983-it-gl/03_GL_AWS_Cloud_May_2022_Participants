
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


module "ec2-1" {
  source = "./ec2"

  ec2_name = "Demo-01"
  ec2_purpose = "WebServer"

}

output "webserver-ec2-instance-id"{
  value = module.ec2-1.ec2_instance_id
}

