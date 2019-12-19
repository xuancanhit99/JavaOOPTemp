package com.company;

class OrderAlreadyAddedException extends Exception {
    OrderAlreadyAddedException(){
        super("Another order already linked with this table/address.");
    }
}
