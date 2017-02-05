import { Injectable } from '@angular/core'

import { Headers, Response, Request, RequestMethod, URLSearchParams, RequestOptions } from "@angular/http";

import { AuthHttp } from 'angular2-jwt'

import { AttachmentReferenceDto } from './interface/attachment-reference-dto'

@Injectable()
export class AttachmentService {

    constructor(private http : AuthHttp) { }

    postAttachment(file: File) {
        let headers = new Headers();

        let formData = new FormData();
        formData.append('file', file, file.name);

        return this.http.post("/api/attachment/upload", formData)
        .toPromise()
        .then(response => response.json().data as AttachmentReferenceDto)
    }

    getAttachmentUrl(attachmentId: string) {
        return `/api/attachment/${attachmentId}`;
    }

}