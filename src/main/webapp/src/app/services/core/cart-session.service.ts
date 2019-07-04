import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { CartDTO } from '@app/model/dto/cart';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CartSessionService {
  private _hasCart = new BehaviorSubject<boolean>(false);
  private _isCartShowing = new BehaviorSubject<boolean>(false);
  private _cartSubject: BehaviorSubject<CartDTO>;

  //TODO externalise URLs
  private _url: string = "http://localhost:8080/api/saveCart";

  constructor(private http: HttpClient) {
    this._cartSubject = new BehaviorSubject(null);
  }

  get _cartSubject$() {
    return this._cartSubject.asObservable();
  }


  get hasCartSubject$() {
    return this._hasCart.asObservable();
  }

  get isCartShowing$() {
    return this._isCartShowing.asObservable();
  }

  createCart() {
    this._cartSubject.next(new CartDTO());
    this.editCartShowingStatus(true);
  }


  deleteCart() {
    this._cartSubject.next(null);
  }

  editCartStatus(newStatus) {
    this._hasCart.next(newStatus);
  }

  editCartShowingStatus(newStatus) {
    this._isCartShowing.next(newStatus);
  }
}
