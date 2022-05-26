import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from './order';
import { environment } from 'src/environments/environment';
import {FormsModule} from '@angular/forms'

@Injectable({providedIn: 'root'})
export class OrderService {
  apiServerUrl: string = environment.apiServerUrl;

  constructor(private http: HttpClient) {}

    public getAllOrders(): Observable<Order[]> {
      console.log(this.http.get<Order[]>(`${this.apiServerUrl}`));
      return this.http.get<Order[]>(`${this.apiServerUrl}`);
    }

    public getOrderById(id: number): Observable<Order> {
      return this.http.get<Order>(`${this.apiServerUrl}/order/${id}`);
    }

    public addOrder(order: Order): Observable<Order> {
      return this.http.post<Order>(`${this.apiServerUrl}`, order);
    }

    public updateOrder(order: Order): Observable<Order> {
      return this.http.put<Order>(`${this.apiServerUrl}/update`,order);
    }

    public deleteOrderById(orderId: number): Observable<void> {
      return this.http.delete<void>(`${this.apiServerUrl}/delete/${orderId}`);
    }


  }
