import useCreateGuildData from '@/hooks/createGuild/useCreateGuildData';
import useFunnel from '@/hooks/useFunnel';
import CreateGuildModal from '@/pages/FriendsPage/components/CreateGuildModal';
import CustomizeGuildModal from '@/pages/FriendsPage/components/CustomizeGuildModal';

type CreateGuildSteps = '서버공개여부' | '서버커스텀';
const STEP_SEQUENCE: CreateGuildSteps[] = ['서버공개여부', '서버커스텀'];

const CreateGuildModalContent = () => {
  const { Funnel, moveToNextStep, moveToPrevStep, currentStep } = useFunnel({
    defaultStep: '서버공개여부',
    stepList: STEP_SEQUENCE,
  });

  const { isPublicGuildProps, guildCustomProps } = useCreateGuildData();

  return (
    <Funnel currentStep={currentStep}>
      <Funnel.Step name="서버공개여부">
        <CreateGuildModal onNext={moveToNextStep} {...isPublicGuildProps} />
      </Funnel.Step>

      <Funnel.Step name="서버커스텀">
        <CustomizeGuildModal onPrev={moveToPrevStep} {...guildCustomProps} />
      </Funnel.Step>
    </Funnel>
  );
};

export default CreateGuildModalContent;
