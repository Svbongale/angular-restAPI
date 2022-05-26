import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Order } from './order';
import { OrderService } from './order.service';
import { FormsModule }  from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

// variable to hold all the orders that is fetched form the backend on the client side
  public orders: Order[];
  public editOrder: Order;
  public deleteOrder: Order;

  constructor(private orderService: OrderService){}

  // it is used to call the methods automatically
  ngOnInit(){
    this.getAllOrders();
  }


  // subscribe() is used to notify when the data comes form the server and is just like a promise that is completed asynchronously
  public getAllOrders(): void{
    this.orderService.getAllOrders().subscribe((response: Order[])=>{
      this.orders = response;
      console.log(this.orders);
    },
    // if the promise fails to return a value then the error is thrown and is just like throw and catch
    (error: HttpErrorResponse) => {
      alert(error.message);
    });
  }


// Add function
  public onAddOrder(addForm: NgForm) {
    document.getElementById('add-order-form').click();
    this.orderService.addOrder(addForm.value).subscribe(
      (response: Order) => {
      console.log(response);
      this.getAllOrders();
      addForm.reset();
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
      addForm.reset();
    });
  }

// Update Function
  public onUpdateOrder(order: Order) {
    document.getElementById('edit-order-form').click();
    this.orderService.updateOrder(order).subscribe(
      (response: Order) => {
      console.log(response);
      this.getAllOrders();
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    });
  }


// delete functionality
  public onDeleteOrder(orderId: number): void {
    document.getElementById('delete-order-form').click();
    this.orderService.deleteOrderById(orderId).subscribe(
      (response: void) => {
      console.log(response);
      this.getAllOrders();
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    });
  }



  // To handel models

  public onOpenModal(order: Order, mode: string) {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if(mode === 'add') {
      button.setAttribute('data-target', '#addNewOrderModal');
    }
    if(mode === 'edit') {
      this.editOrder = order;
      button.setAttribute('data-target', '#updateOrderModal');
    }
    if(mode === 'delete') {
      this.deleteOrder = order;
      button.setAttribute('data-target', '#deleteOrderModal');
    }
    container.appendChild(button);
    button.click();
  }

}
