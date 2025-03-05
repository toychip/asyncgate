package com.asyncgate.chat_server.controller.docs

import com.asyncgate.chat_server.controller.DirectMessageCreate
import com.asyncgate.chat_server.controller.DirectMessageDeleteRequest
import com.asyncgate.chat_server.controller.DirectMessageEditRequest
import com.asyncgate.chat_server.controller.DirectMessageTypingRequest
import com.asyncgate.chat_server.controller.DirectPagingResponse
import com.asyncgate.chat_server.controller.FileRequest
import com.asyncgate.chat_server.controller.FileUploadResponse
import com.asyncgate.chat_server.support.response.SuccessResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.parameters.RequestBody
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.servlet.http.HttpServletRequest
import org.springframework.messaging.Message
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestParam

@Tag(name = "Direct Message API", description = "Direct 메시지 관련 API (WebSocket 기반)")
@SecurityRequirement(name = "JWT TOKEN")
interface DirectControllerDocs {

    @Operation(
        summary = "Direct 메시지 전송 (WebSocket)",
        description = """
            WebSocket을 통해 Direct 메시지를 전송합니다.  
            **STOMP Destination:** `/chat/direct/send-message`  
            
            **Example JSON:**
            ```json
            {
                "channelId": "channel-12345",
                "profileImage": "http://example.com/image.png",
                "name": "John Doe",
                "content": "Hello!",
                "thumbnail": "http://example.com/thumbnail.png"
            }
            ```
        """
    )
    @PutMapping("/chat/direct/send-message")
    fun directJustDocs(
        @Parameter(description = "Direct 메시지 생성 DTO", required = true)
        @Payload
        directMessageCreate: DirectMessageCreate,
        message: Message<*>,
    )

    @Operation(
        summary = "Direct 메시지 타이핑 (WebSocket)",
        description = """
            사용자의 타이핑 상태를 WebSocket으로 전송합니다.  
            **STOMP Destination:** `/chat/direct/typing`
            
            **Example JSON:**
            ```json
            {
                "channelId": "channel-12345",
                "name": "John Doe",
                "content": "Typing..."
            }
            ```
        """
    )
    @PutMapping("/chat/direct/typing")
    fun typingJustDocs(
        @Parameter(description = "타이핑 상태 DTO", required = true)
        @Payload
        directTyping: DirectMessageTypingRequest,
        message: Message<*>,
    )

    @Operation(
        summary = "Direct 메시지 수정 (WebSocket)",
        description = """
            WebSocket을 통해 Direct 메시지를 수정합니다.  
            **STOMP Destination:** `/chat/direct/edit`
            
            **Example JSON:**
            ```json
            {
                "id": "msg-12345",
                "channelId": "channel-12345",
                "name": "John Doe",
                "content": "Edited message"
            }
            ```
        """
    )
    @PutMapping("/chat/direct/edit")
    fun editJustDocs(
        @Parameter(description = "메시지 수정 DTO", required = true)
        @Payload
        directEdit: DirectMessageEditRequest,
        message: Message<*>,
    )

    @Operation(
        summary = "Direct 메시지 삭제 (WebSocket)",
        description = """
            WebSocket을 통해 Direct 메시지를 삭제합니다.  
            **STOMP Destination:** `/chat/direct/delete`
            
            **Example JSON:**
            ```json
            {
                "channelId": "channel-12345",
                "id": "msg-67890"
            }
            ```
        """
    )
    @PutMapping("/chat/direct/delete")
    fun sendDeleteMessageJustDocs(
        @Parameter(description = "메시지 삭제 DTO", required = true)
        @Payload
        directDelete: DirectMessageDeleteRequest,
        message: Message<*>,
    )

    @Operation(
        summary = "Direct 파일 업로드 (HTTP)",
        description = "HTTP를 통해 파일을 업로드하고 Direct 메시지를 전송합니다.",
        requestBody = RequestBody(
            content = [
                Content(
                    mediaType = "multipart/form-data",
                    schema = Schema(implementation = FileRequest::class)
                )
            ]
        )
    )
    @PostMapping("/chat/direct/file")
    fun uploadFile(
        @Parameter(description = "파일 업로드 DTO", required = true)
        @ModelAttribute
        fileRequest: FileRequest,
        servletRequest: HttpServletRequest,
    ): SuccessResponse<FileUploadResponse>

    @Operation(
        summary = "Direct 메시지 페이징 조회 (HTTP)",
        description = "채널에 속한 Direct 메시지를 페이징하여 조회합니다."
    )
    @GetMapping("/chat/direct")
    fun readPaging(
        @Parameter(description = "페이지 번호", example = "0")
        @RequestParam("page", defaultValue = "0")
        page: Int,
        @Parameter(description = "페이지 크기", example = "10")
        @RequestParam("size", defaultValue = "10")
        size: Int,
        @Parameter(description = "채널 ID", example = "channel-12345")
        @RequestParam("channel-id")
        channelId: String,
    ): SuccessResponse<DirectPagingResponse>
}
