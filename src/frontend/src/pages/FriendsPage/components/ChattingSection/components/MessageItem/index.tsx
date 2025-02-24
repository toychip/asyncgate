import * as S from './styles';

export interface MessageItemProps {
  sentUserProfileUrl: string;
  sentUserName: string;
  sentDateTime: string;
  messageContent: string;
  isModified: boolean;
}

const MessageItem = ({
  sentUserProfileUrl,
  sentUserName,
  sentDateTime,
  messageContent,
  isModified,
}: MessageItemProps) => {
  return (
    <S.MessageItem>
      <S.MessageContentContainer>
        <S.SentUserProfileImage src={sentUserProfileUrl} alt="" />
        <S.MessageTitle>
          <S.SentUserName>{sentUserName}</S.SentUserName>
          <S.SentDateTime>{sentDateTime}</S.SentDateTime>
        </S.MessageTitle>
        <S.MessageContent>{messageContent}</S.MessageContent>
      </S.MessageContentContainer>
    </S.MessageItem>
  );
};

export default MessageItem;
