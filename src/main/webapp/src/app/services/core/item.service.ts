import { Injectable } from '@angular/core';
import { Observable } from "rxjs/Observable";
import { of } from 'rxjs';
import { Item } from '@app/model/item';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { CommonResponseDTO } from '@app/model/dto/common-response';
import { Page } from '@app/model/dto/page';

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  private _itemSubject: BehaviorSubject<CommonResponseDTO<Page<Item[]>>>;
 

  private dataStore: {
    page: CommonResponseDTO<Page<Item[]>>;
  };


  private _url: string = "http://localhost:8080/api/listpages?getAll";
  constructor(private http: HttpClient) {

    this._itemSubject = new BehaviorSubject(new CommonResponseDTO<Page<Item[]>>());
    this.dataStore = { page: new CommonResponseDTO<Page<Item[]>>() };
  }

  get item$() {
    return this._itemSubject.asObservable();
  }


  loadAll() {
    this.http.get<CommonResponseDTO<Page<Item[]>>>(this._url)
      .subscribe(data => {
        this.dataStore.page = data;
        this._itemSubject.next(Object.assign({}, this.dataStore).page);
      }, error => console.log('Could not load todos.'));
  }
}