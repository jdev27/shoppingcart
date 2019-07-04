import { ResponseDTO } from '@app/model/dto/response';

export class CommonResponseDTO<T>{
    public data: T;
    public response: ResponseDTO;
}
