import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { ItemService } from '@app/services/core/item.service';
import { Item } from '@app/model/item';
import { CartSessionService } from '@app/services/core/cart-session.service';
import { CommonResponseDTO } from '@app/model/dto/common-response';
import { Page } from '@app/model/dto/page';
import { CartDTO } from '@app/model/dto/cart';
import { CartItemDTO } from '@app/model/dto/cart-item';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { AddCartItemComponent } from '@app/core/modal/add-cart-item/add-cart-item.component';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.scss']
})
export class ItemListComponent implements OnInit {
  displayedColumns: string[] = ['id', 'name', 'description', 'amount', 'action'];

  dataSource = new MatTableDataSource<Item>();
  private hasCart: boolean;
  private cartDTO: CartDTO;
  private page: Page<Item[]>;
  private size: number;
  constructor(private _itemService: ItemService,
    private _cartSessionService: CartSessionService,
    public dialog: MatDialog) { }

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  ngOnInit() {
    this.size = 5;
    this.dataSource.paginator = this.paginator;
    this._itemService.loadAll();
    this._cartSessionService.hasCartSubject$.subscribe(
      hasCart => this.hasCart = hasCart
    );

    this._itemService.item$.subscribe(
      (resp: CommonResponseDTO<Page<Item[]>>) => {
        console.log(resp)
        if (resp && resp.response && resp.response.code
          && resp.response.code == 200) {
          let page = resp.data;
          this.page = page;
          this.dataSource.data = page.content;
        }
      }
    );
    this._cartSessionService._cartSubject$.subscribe(
      cart => {
        this.cartDTO = cart;
      }
    );
  }

  add(item: Item) {
    console.log(this.cartDTO.cartItems);

    const dialogConfig = new MatDialogConfig();
    // dialogConfig.disableClose = true;
    // dialogConfig.autoFocus = true;
    dialogConfig.height = '360px';
    dialogConfig.width = '275px';
    dialogConfig.data = item;
    this.dialog.open(AddCartItemComponent, dialogConfig);
  }
}
