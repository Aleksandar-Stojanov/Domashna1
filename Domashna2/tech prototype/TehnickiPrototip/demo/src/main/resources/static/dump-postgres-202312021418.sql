PGDMP                      {            postgres    16.1    16.1     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    5    postgres    DATABASE     �   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Macedonian_North Macedonia.1251';
    DROP DATABASE postgres;
                postgres    false            �           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    5037            /           1259    17212    wineries    TABLE     Q  CREATE TABLE public.wineries (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    phone character varying(20),
    mobile_phone character varying(20),
    additional_phone character varying(20),
    address character varying(255),
    city character varying(255),
    email character varying(255),
    website character varying(255),
    yellowpages_link character varying(255),
    catalog_link character varying(255),
    facebook_link character varying(255),
    instagram_link character varying(255),
    logo_url character varying(255),
    rating double precision
);
    DROP TABLE public.wineries;
       public         heap    DiansProekt    false            .           1259    17211    wineries_id_seq    SEQUENCE     �   CREATE SEQUENCE public.wineries_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.wineries_id_seq;
       public          DiansProekt    false    303            �           0    0    wineries_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.wineries_id_seq OWNED BY public.wineries.id;
          public          DiansProekt    false    302                       2604    17215    wineries id    DEFAULT     j   ALTER TABLE ONLY public.wineries ALTER COLUMN id SET DEFAULT nextval('public.wineries_id_seq'::regclass);
 :   ALTER TABLE public.wineries ALTER COLUMN id DROP DEFAULT;
       public          DiansProekt    false    303    302    303            �          0    17212    wineries 
   TABLE DATA           �   COPY public.wineries (id, name, phone, mobile_phone, additional_phone, address, city, email, website, yellowpages_link, catalog_link, facebook_link, instagram_link, logo_url, rating) FROM stdin;
    public          DiansProekt    false    303   �       �           0    0    wineries_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.wineries_id_seq', 129, true);
          public          DiansProekt    false    302                       2606    17219    wineries wineries_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.wineries
    ADD CONSTRAINT wineries_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.wineries DROP CONSTRAINT wineries_pkey;
       public            DiansProekt    false    303            �      x��\[o��u~f�
y�d�,^��HT_��n�!@��(��;��;O6	 @f/���Y{�G'H �A�?����s�xU����8�Ј�V��:u��:E"�S�#���3�N�Wb�]��ɺnPE�7HV��LE�X44��v���v�����<Z|-��ӿ���<H�@����'�|"���v�^��F�?g���ep��]�Oe�:J�L�?�A�d'q�B�#���`����*��t����j�bj�up^���X.�c�F��:�I������1�㝼L⋀�����\��d4T!��;��\̄��%(&�5��6y%��s��3vZ����$^M�IpN�����m3I.j�R�mE�s)�����->�+�^��ڲ+�T]C+�����I�R���*�"��TUPTl$
U�c4tŖ�9:q�"ќ�P�WG%�.�e�p���]���Xv4�iI���J!i�uQ�mQ���|ҫ��E�Fea�[�,Ć��~_�Lx2�m���%d�����lkPoPP�n�k�����	!*U��fý���r}py���~��4�mۭz������;�0Œq(�6���_B����0-���u4gм��̣i=D��+����0�����z��<��N�I�[\ݯ�It���ZZt�y���{�0JC�����$�t�cғ�:����v����h"L��&C5v�����6��\O���d6L��g]����)��0��w�@G�bw�גU�R����1����9����~��l?����Rd�c�ᘤ8&9�"�n�i�;��qI0�-�a	CX�m'��+�����(�Eg�
D�ZB�uܾ�$Ӏ��fD�=ImK���~���2�2(�@��|X�~�"h�f����O�@��n���â�g�Cf	5�06�V�~�����"
C��zh�4�X��K;�4���5:7�c�Ɏӕ�D���l	|m�����g˒��3P�A���F���Ŵu[ィ�"�Oz�n���D;5r(W	tU���2�r�v�K�AT��� 64D(�YS_XE�m��=[��zʩ)����+�A��x��J�E��m�V��n�O@[�{��	L�fÑׯ� ��Ӟ���!!`��.8�1*��˚E����:���C ���8��?��$Z���:����{�#��"�
 Z�P���ә*�N���t���jr�������i��!_6���`˹�����M�������	���k	��:>�./o�We�򨩎��,UNd�t�e
��/=��Y���P-g$��&�_a,���`2Yk���bax�x]��Us^�BPC�d�{2�&�w����p�3} {�p ��F�zf`:=�2��!3��A�aˬ�ɤ$&� ��c�xκ4� ê�%j(Ĳl6���h@o����W�h5��u��:�rw��J骦S��>��9�*��6TE8<;=k���{�AeKWl�d~������-��[�u\���O�ZC %�cCk��R��l�HD5�X������>�:�lu��(��?�ҟ�.�i	�HEC'�C�OlT���Zf��V�8Y��xg���wu��� u�F�����:m_��L�M�]�u8H"�0d�4�<��dO+!�iR�	�b7TX�n�=J�����Gv��o�g�HlE�`Q���p^�&�b�W���;�ȄB�v~t,����k��p�7�N�$@�ʶ�!Z���ӻ`q�=��Y����9��I-kmX2�7)�,�P�1�fh?�	XQ���p��f���e��!���@�f�z�`_&	K�9볘Y�c
i$\D��|A~�}@���x):�
�v9�}@޽>࿪�,�� o��1� ���J1�������Q0pF	x��5�x�d޿��!\����:L��?�w1ǿkjg�}x���6Ǩ^Mv��j��SK5���H5�l�6����_l��]�l\�Nu���p��hz?�sȱ/"���4���|��$�{Ǩ��K U������ �織�A; �fp/g�'̌���]��lX��3� ���>���=��\�j�&U�J�bWX̢�4-p��jȖ�R��t��j�74R�N�4��
'Э$��/�`u��U=Ő�"g��<D}��u�Q�;�Kf���ex1�b@����:�;�~�X
x��A��7�H�o6o7���w��������
~��|�yQ��R 2|�������6�&���<�|Qa�Z)���t�*�r
�X'�n>`��o��;�x�}	M_ ꗛ"��y&�;��6�`Y ���}|5��y�n����J>�]JFv��aN����~��U��D �|���7 ��o� �8���j�LAn��O�y/���h]wCB5��m�� @�1��D��h12�SD}�J�nP�j�4X����8������7�{���ߖ����<3v��"�ʆ����ԭ]���I��4}�qR�� �J�U�Bf��nhF!BԱ дUbg7���WP�W��sT�ͯQ�D��Ϸ��{�o����v4�PvS��R,���!�/�������b���������d�[��O��Q5X�4K�.S3�dòAF��m0
 �o7���K���.��/��? H��+ɮځ���4�Y���2^�Y��N�%?pD�	$�R><~S���gӆ*Q`Y&�U}�k����53�ϳ�J�Ymhv{��'��*7��,1�\Y�bT՗[l_�}	Ƙ�v$���	Ŧ�0�n�m~�*�b��K�e8�=��TL�g��
�� �m�<�m��*�ʃ�Z�����!���.Ã�:��RÔ*ϣ�Z�%�.S���9���E6�^~�e�q����w]�t���kx�w8�"�ޟ��I�7��:gC�)44L}s���D��k�|#.ٷ�i�����RP�9�U�OС�v�4���vCg��u�t2b����	��W��o��L�j��B@a0���4��'�y���u�J�z#w�sF��Cڣ"�1��e+@��j�����wp�5�ʷ��Ui�X�9w�����i$��o�J�Iz���WZʅ����b�Uxp���{���S��[�%���̍�́ߴta�+�dlѢ��Эl>�6��f���Eb}��vA>�o���-v[1;�w��gǢ�bi�����K�f{j�_�0�}|��d^�Kf��d��6�������#��c�I�vx��S]V�����-�봇)Z�h�$5�Rp�Ð�U��;��,����tU�oNt�!D�_�$w���G#j�"QEe�Y&Le��u����ZZ����7_�XD-`���t�nP暆mD�XM���fR%��xCv�	��(���o��~Ͳ�\�l�&Lp���,)iP�V0RFD�Im�����W|}=�N�^k	�������R�V����?��x0饂;0��0�3�gآT�2��]�3�� �z�)_~Sg���3�
���:�c|�p�vt�d�6��8�;GHBz���޹�sJ;6�a���Y�*��CgW�"
�8��y������~�:F9��?�`�|��yz�*p15�-3����2%��(a9:䁿b����[�`�,Z��E����n��U���� �]�䏚�E�`��b��+�֬e���Rz(x����B�:��!�j�b.�Mf���|�l�A��-`y&��:pz�UFVi��)�b�7uU�b �,WA㭂�II�k�� EFс]����N_��Ę�ڳؗű1{5)A��`
��V�qgQ�tKo��o�I �_ E�$���|�9�T٪�����Z;�k�ko�#��Ŏe�A��}�ܼnB;gB
�z2�~��c/��D�~&�Ϡ��59ﭼ�G!|��y��z|�H�w0��9"�����͸��"U��"�B�6́�5X����L* 
�`(�_���[ESL~i*g>/1���,�3czǜ7���	���L����*0E�@*; ��!�.��ZCI��w��D����zYDe�5����@g���Y �G-���m���Cg�ec��{�u�Q�0x݅�` �  ��X&��c���Qz��0��$���� |ͣ5R��b�n�Wͨ�Q�ݼeU��M��q�W�-Š�]��������C�3v��j�g!���͞hg{;=m����')�2�7t�����W3L"	~i`�O�Փ:��m���J�x�����p�|-- W�_�`���4X����z��!�X�e6*�]g����-���xP�!*"fZdB����v��QXY��<Hr�T����dX2C0)!ء1������������_u�^��m�,^W����IO~o$�;�$)�T�&�g���ME�w����RM������ j��L�n[�5N|qx�]�gSݷtȠ �����	��l��8����J>�e��T;/ *���p�
W��$���pV��Vk-ziir	T3����,���Bk�.`U����.Ĩ��������K�i[�����;�5#�+�	\7�E�0v5����rx�"�f��9��!���uO{��VE6�������L�$K����4���۰�K�!�Z[/H=sT�՟S��c#�<C�$�G�O�T(�X��u��HG�]�̴eYL":�V��A�<��<M�>?����PṔ\Ǫ-u(�n2�p@;���s�����aj�w>��LS�!6�Tx<!:��>�I��?j�S�d*T�z+�D���1lD�L�8��ݞ��N��/:}8�;XI
zA91�I�EN�i�Vc=7���I����cӵ��)�s;|��W�ք�21<���b5��~��A����0S��x�g�A��}�r]κ�(�����>��DB�j �a�-88=~LF�uK�9�:��I�����75٨wN��$Xԭ� �S伿r��4K8xؠ��'�V0��K�s⏽#QՊ:�L�ʠ�H�+=M,��{���m�Ŕ^&ϋU�_=玚`�����fmw�v3 �<��%=��f�r�|�BgM.?�'��t���?.;�ig�#*����"1����o�Q<�{W�Ѱ��c}t����sEj��Ź�p\Ieo�*Q��~O�cբ�r�;V-��?�\3_7)��3�6y��"ߴ�]��;�=,���85Z�y3�z�K����7TN;+����b�^S�T�"�Q�
FjA<8<i�a;'� �8��?e�_��ӈ  �®�e�6,]h��x��k���12r2�)��覉�p2�N�	��W�:��-أ�K#
��J��9�`Q��C�X=�dj��V,`��j��S�~�Y����\ �4���IP �O�d�ʵ�IMRLU���G�n%(;Խ�����:޸8��&Q%hz��b)�N>Ut��F޹��:�$��!(v��n�@Va ��Gs�Dw]��Bp���q�I�<_�yq��yg^��?��R����y��N��[B��fR�.+��bм�ox�|��Xy2�м�K4�a�����:nԠ���NJx*�����0u�:�2��Cg���o�L-xP��2� :�Z�<)w��C)�MZ�s�3T�B���J���@��w���:�e7@3��s,rtF��;nz�L��� :���A��b�A�Y�ܝ��N�$X��G!�I�ϲ��U��u1l�2ILk˩֗�*,z��k�N;b����L�0>�O��Y���P�Żf�$Z)t��<> C_�W�_�h+���3C���lw[�L����uz-4%^�h������Ssr�.��DX*U�@9�`S����B:�4��l!�}i�Bh�5+��e8C��L+hۭuj]uŒ0��K���x���L��b�a��Mm������CH��:OK��K���ar��ؕ;���9�)�h˂�*�B��SM0�N�)�1s�ࡑ8�{U����%ג���}"X� @���@;�mf�T�4�/Ȗt<8sǢ��R^F�M�����G������i�ź��hFMa�����f~��p��ъ�s��$�_��a�:��!gʩE���ڕ�`��+���/�=�({�S��.��>����A�A��,�D,-�_	�w���V��S�C�@@��eeEo������}�oRY� �v
X�g�Y#�p�C��9�L�ɲ5�3�����J���������@�!k��(A�2�9a0�:���a'��e���i�$���� ��:	���@*0���N�$�^!(���Eֈ�*<�<�Z���B<�� �N»eK��]Z�����2gBW8��}���ݼLWl=��b%�M|p��:�C(� {��=��Q���VT]��MMKsC�?�����-<!��""��˰\p�m5m &xvB�h@�������N���az�S�=��z�Vg��'��d�0������Μi`�Ӯ���[�h8�_�d�q;}��N�8�E����{|�2"+y���Lp�����I`��np'^$�e�Q�WI\%�)S�;~Q~���d0�R'�LC':�x��
�໧��E@$m��4�KL4
�h�?�/3�մ|2��O�;�N��@8���7������15�������j�	��3<�2`$e��"ɺZGK��aq[������rv��KF��.�S���d��� 9痺ɒ�Ci����[�wx�4�,�Y��B��Ј\ � N.D�&��f�k�/��dPf�l�V�Ld�*+��>kN�����]��5� �x���y�Z�ɻ�mُ�o2i��D �7t�W�y� �f���_���4ۄ9��	��A��T�0��cwx���E����N���d��><�������$�-5��T!���cF�?��M5�(`�9��d�P�Vv�i����/t#�>��<.#����V�ޒ���hw�*2{Nu�Z����r,J����)8#����d_ކ�B���:�TE�ݖ�I���h��5��X#��=u:�h�}8V��[�P��/bĪ8�Xm�[]`*�\�c�i�M
t�&4�[5��E�U��6nf�7�luzX�=o���I�X��4��F�*����$J�@�D�̲�&!r�Ue���M%xB�pTR��A5A���C�v�s�n�'1��p����%��>�WeUZ��^r�m����m�� �z��
O܁�ڣA�~b�;��e�F��S,Mؼų�XX����f%֢�Te}G��u���,���ܣ>j�������/YY�����KV��v׀�4

�)�N�������~�rf��e�o�������l��^4�ݓ�?HS=GY�1��Q,:ş߰�ip���KV����^��$K��?�HU<��KV{�5?���*�)�.�����x�I#f�zRV��y.���X��O"�9�y��2���;�G9��y��*��ԗ��V��Ӵ�������?@�6���]��6�>;]��P�=J�lJ�*/���T8�t��"�M(� �����g���Tq�o�"K�|��'�?{�S<Ľ�=N#+#ǒw�Ɨ��,��Nj��g55�6�/6/�CE��G�i-���>W�ye{��!��!��d�@��sA��]��%ˑD��?�N9T�921ӫ����n���9�lW��KZ��������0��3�E�b�<����-�M__�Uc]��Z2;F���{�
�˧�x�G���N��*�VuQ`��9W�U���q�WU�k�RN�
�Wm����y��i,%���дt����c��Ta��8 ���,�S��:U����avĆ��^K���I�F�� �#     