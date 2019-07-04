import { Component, OnInit } from '@angular/core';
import { JumbotronService } from '@app/services/core/jumbotron.service';
import { CartSessionService } from '@app/services/core/cart-session.service';
import { CartDTO } from '@app/model/dto/cart';
import { CartItemDTO } from '@app/model/dto/cart-item';


@Component({
  selector: 'app-jumbrotron',
  templateUrl: './jumbrotron.component.html',
  styleUrls: ['./jumbrotron.component.scss']
})
export class JumbrotronComponent implements OnInit {


  public title: string;
  public description: string;
  public isCartShowing: boolean;
  private cartDTO: CartDTO;

  constructor(private _jumbotronService: JumbotronService,
    private _cartSessionService: CartSessionService) {
  }

  ngOnInit() {
    this._jumbotronService.getJumbotron().subscribe(
      data => {
        this.title = data.title;
        this.description = data.description;
      }
    )
    this._cartSessionService.isCartShowing$.subscribe(
      isCartShowing => this.isCartShowing = isCartShowing
    );
    this._cartSessionService._cartSubject$.subscribe(
      cart => {
        this.cartDTO = cart;
      }
    );
  }

  getSubTotal(cartItem: CartItemDTO) {
    let subTotal: number = cartItem.item.amount * cartItem.quantity;
    return subTotal;
  }

  delete(index: number) {
    this.cartDTO.cartItems.splice(index, 1);
  }
  
  getTotal() {
    this.cartDTO.cartItems

    let total = 0;
    for (let cartItem of this.cartDTO.cartItems) {
      total += cartItem.item.amount * cartItem.quantity;
    }
    return total;
  }

}
