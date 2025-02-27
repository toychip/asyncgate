const parseMessageDateTime = (dateTime: Date) => {
  const year = dateTime.getFullYear();
  const month = dateTime.getMonth() + 1;
  const day = dateTime.getDate();

  const hours = dateTime.getHours();
  const minutes = dateTime.getMinutes();
  const isPmHours = hours > 12;

  const timeData = isPmHours ? `오후 ${hours - 12}:${minutes}` : `오전 ${hours}:${minutes}`;

  return `${year}.${month}.${day}. ${timeData}`;
};

export default parseMessageDateTime;
