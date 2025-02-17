import { useState } from 'react';

import { Description } from '@/components/common/AuthInput';
import { YearMonthDay } from '@/types';

import { DESCRIPTION_NICKNAME, DESCRIPTION_REQUIRED, DESCRIPTION_USERNAME } from '../constants';

interface RegisterForm {
  email: string;
  nickname?: string;
  username: string;
  password: string;
  birthday: YearMonthDay;
  isOptIn: boolean;
}

type DescriptionState = Partial<Record<keyof Omit<RegisterForm, 'isOptIn'>, Description | null>>;
type IsValidState = Record<keyof Omit<RegisterForm, 'isOptIn' | 'nickname'>, boolean>;

const useRegister = () => {
  // 이메일 중복 검사 후 description 띄우기
  const [userData, setUserData] = useState<RegisterForm>({
    email: '',
    nickname: '',
    username: '',
    password: '',
    birthday: { year: '', month: '', day: '' },
    isOptIn: false,
  });

  const [description, setDescription] = useState<DescriptionState>({
    email: null,
    nickname: DESCRIPTION_NICKNAME.normal,
    username: DESCRIPTION_USERNAME.normal,
    password: null,
    birthday: null,
  });

  const [isValid, setIsValid] = useState<IsValidState>({
    email: false,
    username: false,
    password: false,
    birthday: false,
  });

  const isBirthdayValid = !!userData.birthday.year && !!userData.birthday.month && !!userData.birthday.day;

  const isFormValid = !!userData.email && !!userData.username && !!userData.password && isBirthdayValid;

  const validateRequiredData = () => {
    if (!userData.email.trim()) setDescription((prev) => ({ ...prev, email: DESCRIPTION_REQUIRED }));
    if (!userData.username.trim()) setDescription((prev) => ({ ...prev, username: DESCRIPTION_REQUIRED }));
    if (!userData.password.trim()) setDescription((prev) => ({ ...prev, password: DESCRIPTION_REQUIRED }));
    if (!isBirthdayValid) setDescription((prev) => ({ ...prev, birthday: DESCRIPTION_REQUIRED }));
  };

  const handleEmailChange = (value: string) => {
    setUserData((prev) => {
      return { ...prev, email: value };
    });

    const isEmptyValue = value.trim().length === 0;
    setIsValid((prev) => ({ ...prev, email: !isEmptyValue }));

    if (isEmptyValue) return setDescription((prev) => ({ ...prev, email: DESCRIPTION_REQUIRED }));
    setDescription((prev) => ({ ...prev, email: null }));
  };

  const handleNicknameChange = (value: string) => {
    setUserData((prev) => {
      return { ...prev, nickname: value };
    });
  };

  const handleUsernameChange = (value: string) => {
    setUserData((prev) => {
      return { ...prev, username: value };
    });

    const isEmptyValue = value.trim().length === 0;
    const USERNAME_REGEX = /^[a-zA-Z0-9_.]+$/;

    if (isEmptyValue) {
      setIsValid((prev) => ({ ...prev, email: false }));
      return setDescription((prev) => ({ ...prev, username: DESCRIPTION_REQUIRED }));
    }

    if (USERNAME_REGEX.test(value)) {
      setIsValid((prev) => ({ ...prev, email: true }));
      return setDescription((prev) => ({ ...prev, username: DESCRIPTION_USERNAME.valid }));
    }

    setIsValid((prev) => ({ ...prev, email: false }));
    setDescription((prev) => ({ ...prev, username: DESCRIPTION_USERNAME.error }));
  };

  const handlePasswordChange = (value: string) => {
    setUserData((prev) => {
      return { ...prev, password: value };
    });

    const isEmptyValue = value.trim().length === 0;
    setIsValid((prev) => ({ ...prev, password: !isEmptyValue }));

    if (isEmptyValue) return setDescription((prev) => ({ ...prev, password: DESCRIPTION_REQUIRED }));
    setDescription((prev) => ({ ...prev, password: null }));
  };

  const handleBirthdayChange = (value: YearMonthDay) => {
    setUserData((prev) => {
      return { ...prev, birthday: value };
    });

    const isValidBirthday = !!value.year && !!value.month && !!value.day;

    setIsValid((prev) => ({ ...prev, birthday: isValidBirthday }));

    if (isValidBirthday) {
      setDescription((prev) => ({ ...prev, birthday: null }));
    }
  };

  const handleOptInCheckboxClick = () => {
    setUserData((prev) => {
      return { ...prev, isOptIn: !prev.isOptIn };
    });
  };

  return {
    userData,
    description,
    isValid,
    isFormValid,
    validateRequiredData,
    handleEmailChange,
    handleNicknameChange,
    handleUsernameChange,
    handlePasswordChange,
    handleBirthdayChange,
    handleOptInCheckboxClick,
  };
};

export default useRegister;
