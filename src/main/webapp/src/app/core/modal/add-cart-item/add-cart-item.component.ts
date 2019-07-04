import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Item } from '@app/model/item';
import { CartItemDTO } from '@app/model/dto/cart-item';
import { CartSessionService } from '@app/services/core/cart-session.service';
import { CartDTO } from '@app/model/dto/cart';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-add-cart-item',
  templateUrl: './add-cart-item.component.html',
  styleUrls: ['./add-cart-item.component.scss']
})
export class AddCartItemComponent implements OnInit {
  public quantity: number;
  public test = 0;
  private cartDTO: CartDTO;
  constructor(public dialogRef: MatDialogRef<AddCartItemComponent>,
    @Inject(MAT_DIALOG_DATA) public item: Item,
    private _cartSessionService: CartSessionService,
    private _snackBar: MatSnackBar) { }

  ngOnInit() {
    this._cartSessionService._cartSubject$.subscribe(
      cart => {
        this.cartDTO = cart;
      }
    );
  }

  close() {
    this.dialogRef.close();
  }

  addItem(quantity, item) {
    //new cart item 
    if (quantity > 0) {
      var exists = this.cartDTO.cartItems.find(it => it.item.id == item.id);
      if (!exists) {
        var cartItem = new CartItemDTO();
        cartItem.item = item;
        cartItem.quantity = quantity;
        this.cartDTO.cartItems.push(cartItem);
        this.dialogRef.close();
      } else {
        this.openSnackBar("Item is Already in Cart");
      }
    } else {
      this.openSnackBar("Quantity must not be 0");
    }
  }

  getSubtotal() {
    var quan = this.quantity;
    let product = 0;
    if (quan) {
      product = this.item.amount * quan;
    }
    this.test = product;
  }

  openSnackBar(message: string) {
    this._snackBar.open(message, 'Dismiss', {
      duration: 3000,
      panelClass: ['background']
    });
  }
}

