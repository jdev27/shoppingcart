import { Component, OnInit } from '@angular/core';
import { CartSessionService } from '@app/services/core/cart-session.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements OnInit {
  private hasCart: boolean;
  private cart;
  private isCartShowing: boolean;
  constructor(private _cartSessionService: CartSessionService) { }

  ngOnInit() {
    this._cartSessionService.hasCartSubject$.subscribe(
      hasCart => this.hasCart = hasCart
    );
    this._cartSessionService._cartSubject$.subscribe(
      cart => this.cart = cart
    );
    this._cartSessionService.isCartShowing$.subscribe(
      isCartShowing => this.isCartShowing = isCartShowing
    );
  }
  createShoppingCart() {
    this._cartSessionService.createCart();
    this._cartSessionService.editCartStatus(true);
  }
  lookShoppingCart() {
    this._cartSessionService.editCartShowingStatus(true);
  }
  hideShoppingCart() {
    this._cartSessionService.editCartShowingStatus(false);
  }
  deleteCart() {
    this._cartSessionService.deleteCart();
    this._cartSessionService.editCartStatus(false);
  }
}
