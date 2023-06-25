
variable "my_securitygroup_name" {
  
  type = string
  default = "Default Security Group"
}

variable "demo_port_no" {
  
  type = number
  default = 8888
}

variable "connection_open_or_not" {
  
  default = true
}

variable "list_port_numbers" {
  
  type = list(number)
  default = [22, 80, 443]
}

variable "ec2_resource_tags" {

  type = map
  default = {

    EC2IntanceName = "DemoEC2"
    EC2CreatedBy = "Terraform Program"
  }
}