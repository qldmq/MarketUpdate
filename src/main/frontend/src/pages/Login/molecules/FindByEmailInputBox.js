import PTag from "../atoms/PTag";
import LoginInput from "../atoms/Input";
import Message from "../atoms/Message";
const FindByEmailInputBox = ({ user, setUser }) => {
  const onChangeInput = (e) => {
    const { name, value } = e.target;
    const numericValue = value.replace(/[^0-9]/g, "");
    setUser({ ...user, [name]: numericValue });
  };
  return (
    <>
      <Message info>
        가입시 등록했던 휴대폰 번호를 입력하면 <br />
        이메일의 일부를 알려드립니다.
      </Message>

      <PTag>휴대폰 번호*</PTag>
      <LoginInput
        onChange={onChangeInput}
        name="userPhone"
        value={user.userPhone}
        type="test"
        maxLength={11}
        placeholder="예시) 01012345678"
      />
    </>
  );
};

export default FindByEmailInputBox;
