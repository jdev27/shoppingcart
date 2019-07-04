import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppMaterialModule } from '@app/app-material';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NavBarComponent } from './core/nav-bar/nav-bar.component';
import { JumbrotronComponent } from './core/jumbrotron/jumbrotron.component';
import { ItemListComponent } from './core/item-list/item-list.component';
import { AddCartItemComponent } from './core/modal/add-cart-item/add-cart-item.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  entryComponents: [AddCartItemComponent],
  declarations: [
    AppComponent,
    NavBarComponent,
    JumbrotronComponent,
    ItemListComponent,
    AddCartItemComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AppMaterialModule,
    ReactiveFormsModule,
    HttpClientModule, FormsModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
