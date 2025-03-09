import com.asyncgate.chat_server.domain.DirectMessageType
import com.asyncgate.chat_server.entity.MongoBaseTimeEntity
import jakarta.persistence.PostLoad
import jakarta.persistence.PostPersist
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.domain.Persistable
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "directMessage")
data class DirectMessageEntity(
    @get:Id
    val id: String,

    val channelId: String,
    val userId: String,
    val type: DirectMessageType,
    val profileImage: String? = null,
    val read: Map<Long, Boolean>? = null,
    val name: String? = null,
    val content: String? = null,
    val thumbnail: String? = null,
    val parentId: String? = null,
    val parentName: String? = null,
    val parentContent: String? = null,
    var isDeleted: Boolean = false,
) : MongoBaseTimeEntity(), Persistable<String> {

    @Transient
    private var isNew: Boolean = true

    override fun getId(): String = id

    override fun isNew(): Boolean = isNew

    @PostPersist
    @PostLoad
    fun markNotNew() {
        isNew = false
    }
}
